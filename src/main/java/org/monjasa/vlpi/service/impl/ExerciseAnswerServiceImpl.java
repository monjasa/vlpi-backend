package org.monjasa.vlpi.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.vlpi.domain.ExerciseAnswer;
import org.monjasa.vlpi.dto.ExerciseAnswerDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseAnswerRequest;
import org.monjasa.vlpi.repository.ExerciseAnswerRepository;
import org.monjasa.vlpi.security.service.PrincipalUserDetailsService;
import org.monjasa.vlpi.service.ExerciseAnswerService;
import org.monjasa.vlpi.util.mapper.ExerciseAnswerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseAnswerServiceImpl implements ExerciseAnswerService {

    private final PrincipalUserDetailsService principalUserDetailsService;

    private final ExerciseAnswerRepository exerciseAnswerRepository;

    private final ExerciseAnswerMapper exerciseAnswerMapper;

    @Override
    public List<ExerciseAnswerDto> getAllByUserAccountId(Long userAccountId) {
        return exerciseAnswerRepository.findAllFetchingTaskAnswersByUserAccountId(userAccountId)
                .stream()
                .map(exerciseAnswerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersistableDto create(ExerciseAnswerRequest exerciseAnswerRequest) {
        ExerciseAnswer exerciseAnswer = exerciseAnswerMapper.toEntity(exerciseAnswerRequest);
        exerciseAnswer.setUserAccount(principalUserDetailsService.loadAuthenticatedUser());

        return exerciseAnswerMapper.toPersistableDto(exerciseAnswerRepository.save(exerciseAnswer));
    }
}
