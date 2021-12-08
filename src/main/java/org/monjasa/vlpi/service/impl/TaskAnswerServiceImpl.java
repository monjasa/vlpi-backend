package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.domain.ExerciseAnswer;
import org.monjasa.vlpi.domain.SolutionBlock;
import org.monjasa.vlpi.domain.Task;
import org.monjasa.vlpi.domain.TaskAnswer;
import org.monjasa.vlpi.dto.TaskAnswerDto;
import org.monjasa.vlpi.dto.request.TaskAnswerRequest;
import org.monjasa.vlpi.exception.NotFoundException;
import org.monjasa.vlpi.repository.SolutionBlockRepository;
import org.monjasa.vlpi.repository.TaskAnswerRepository;
import org.monjasa.vlpi.repository.TaskRepository;
import org.monjasa.vlpi.service.TaskAnswerService;
import org.monjasa.vlpi.util.mapper.TaskAnswerMapper;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TaskAnswerServiceImpl implements TaskAnswerService {

    public static final int SCORE_NOT_SOLUTION = 0;

    private final TaskAnswerRepository taskAnswerRepository;

    private final TaskRepository taskRepository;

    private final SolutionBlockRepository solutionBlockRepository;

    private final TaskAnswerMapper taskAnswerMapper;

    @Override
    public TaskAnswerDto create(TaskAnswerRequest taskAnswerRequest, ExerciseAnswer exerciseAnswer) {
        Task task = taskRepository.findById(taskAnswerRequest.getTaskId())
                .orElseThrow(NotFoundException::new);

        TaskAnswer taskAnswer = taskAnswerMapper.toEntity(taskAnswerRequest, exerciseAnswer);
        taskAnswer.setScore(getScore(taskAnswerRequest, task));
        return taskAnswerMapper.toDto(taskAnswerRepository.save(taskAnswer));
    }

    private int getScore(TaskAnswerRequest taskAnswerRequest, Task task) {
        List<SolutionBlock> solutionBlocks = solutionBlockRepository.findAllForSolutionByTaskId(task.getId());
        return isSolution(solutionBlocks, taskAnswerRequest.getSolutionBlockIds())
                ? task.getScore()
                : SCORE_NOT_SOLUTION;
    }

    private boolean isSolution(List<SolutionBlock> solutionBlocks, List<Long> solutionBlockIds) {
        Iterator<SolutionBlock> solutionBlockIterator = solutionBlocks.iterator();
        Iterator<Long> solutionBlockIdIterator = solutionBlockIds.iterator();

        while (solutionBlockIdIterator.hasNext() && solutionBlockIterator.hasNext()) {
            SolutionBlock solutionBlock = solutionBlockIterator.next();
            Long solutionBlockId = solutionBlockIdIterator.next();
            if (!Objects.equals(solutionBlock.getId(), solutionBlockId)) {
                return false;
            }
        }

        return !solutionBlockIdIterator.hasNext() && !solutionBlockIterator.hasNext();
    }
}
