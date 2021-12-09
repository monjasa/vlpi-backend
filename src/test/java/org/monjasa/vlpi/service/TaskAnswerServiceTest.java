package org.monjasa.vlpi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.monjasa.vlpi.domain.Task;
import org.monjasa.vlpi.domain.TaskAnswer;
import org.monjasa.vlpi.dto.TaskAnswerDto;
import org.monjasa.vlpi.dto.request.TaskAnswerRequest;
import org.monjasa.vlpi.repository.SolutionBlockRepository;
import org.monjasa.vlpi.repository.TaskAnswerRepository;
import org.monjasa.vlpi.repository.TaskRepository;
import org.monjasa.vlpi.service.impl.TaskAnswerServiceImpl;
import org.monjasa.vlpi.util.mapper.TaskAnswerMapper;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.monjasa.vlpi.service.TaskAnswerServiceTest.TaskAnswerServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
class TaskAnswerServiceTest {

    @Mock private TaskAnswerRepository taskAnswerRepository;

    @Mock private TaskRepository taskRepository;

    @Mock private SolutionBlockRepository solutionBlockRepository;

    @Mock private TaskAnswerMapper taskAnswerMapper;

    private TaskAnswerService taskAnswerService;

    @BeforeEach
    public void init() {
        this.taskAnswerService = new TaskAnswerServiceImpl(
                taskAnswerRepository,
                taskRepository,
                solutionBlockRepository,
                taskAnswerMapper
        );
    }

    @Test
    void createWithoutSolutionBlocksValidRequestMappedToValidEntity() {
        TaskAnswerRequest taskAnswerRequest = new TaskAnswerRequest();
        taskAnswerRequest.setTaskId(TASK_ID_VALID);
        taskAnswerRequest.setExerciseAnswerId(EXERCISE_ANSWER_ID_VALID);
        taskAnswerRequest.setSolutionBlockIds(Collections.emptyList());

        Task task = mockTaskRepositoryFindById();
        mockTaskAnswerMapperToEntity(taskAnswerRequest, task);
        mockTaskAnswerMapperToDto();
        mockTaskAnswerRepositorySave();

        TaskAnswerDto taskAnswerDto = taskAnswerService.create(taskAnswerRequest);

        assertThat(taskAnswerDto).isNotNull()
                .isExactlyInstanceOf(TaskAnswerDto.class)
                .hasNoNullFieldsOrProperties()
                .extracting(
                        TaskAnswerDto::getId,
                        TaskAnswerDto::getScore
                )
                .doesNotContainNull()
                .containsExactly(
                        TASK_ANSWER_ID_VALID,
                        TASK_SCORE_VALID
                );
    }

    private Task mockTaskRepositoryFindById() {
        Task task = new Task();
        task.setSolutionBlocks(Collections.emptyList());
        task.setScore(TASK_SCORE_VALID);

        when(taskRepository.findById(TASK_ID_VALID)).thenReturn(Optional.of(task));

        return task;
    }

    private void mockTaskAnswerMapperToEntity(TaskAnswerRequest taskAnswerRequest, Task task) {
        TaskAnswer taskAnswer = new TaskAnswer();
        taskAnswer.setId(TASK_ANSWER_ID_VALID);
        taskAnswer.setTask(task);

        when(taskAnswerMapper.toEntity(taskAnswerRequest)).thenReturn(taskAnswer);
    }

    private void mockTaskAnswerMapperToDto() {
        when(taskAnswerMapper.toDto(any(TaskAnswer.class)))
                .thenAnswer(invocationOnMock -> {
                    TaskAnswer taskAnswer = (TaskAnswer) invocationOnMock.getArguments()[0];
                    TaskAnswerDto taskAnswerDto = new TaskAnswerDto();
                    taskAnswerDto.setId(taskAnswer.getId());
                    taskAnswerDto.setScore(taskAnswer.getScore());
                    return taskAnswerDto;
                });
    }

    private void mockTaskAnswerRepositorySave() {
        when(taskAnswerRepository.save(any(TaskAnswer.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[0]);
    }

    public static class TaskAnswerServiceTestConstants {

        public static final Long TASK_ID_VALID = 100L;

        public static final Integer TASK_SCORE_VALID = 100;

        public static final Long TASK_ANSWER_ID_VALID = 1000L;

        public static final Long EXERCISE_ANSWER_ID_VALID = 10L;

    }
}