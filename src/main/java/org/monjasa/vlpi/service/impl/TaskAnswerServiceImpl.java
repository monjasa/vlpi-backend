package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
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
    public TaskAnswerDto create(TaskAnswerRequest taskAnswerRequest) {
        Task task = taskRepository.findById(taskAnswerRequest.getTaskId())
                .orElseThrow(NotFoundException::new);

        TaskAnswer taskAnswer = taskAnswerMapper.toEntity(taskAnswerRequest);
        taskAnswer.setIsSolution(isTaskAnswerSolution(taskAnswerRequest));
        taskAnswer.setScore(taskAnswer.getIsSolution() ? task.getScore() : SCORE_NOT_SOLUTION);

        return taskAnswerMapper.toDto(taskAnswerRepository.save(taskAnswer));
    }

    private boolean isTaskAnswerSolution(TaskAnswerRequest taskAnswerRequest) {
        List<SolutionBlock> solutionBlocks = solutionBlockRepository.findAllForSolutionByTaskId(taskAnswerRequest.getTaskId());
        Iterator<SolutionBlock> solutionBlockIterator = solutionBlocks.iterator();
        Iterator<Long> taskAnswerSolutionBlockIdIterator = taskAnswerRequest.getSolutionBlockIds().iterator();

        while (taskAnswerSolutionBlockIdIterator.hasNext() && solutionBlockIterator.hasNext()) {
            if (!isSolutionBlockMatched(solutionBlockIterator.next(), taskAnswerSolutionBlockIdIterator.next())) {
                return false;
            }
        }

        return !taskAnswerSolutionBlockIdIterator.hasNext() && !solutionBlockIterator.hasNext();
    }

    private boolean isSolutionBlockMatched(SolutionBlock solutionBlock, Long taskAnswerSolutionBlockId) {
        return Objects.equals(solutionBlock.getId(), taskAnswerSolutionBlockId);
    }
}
