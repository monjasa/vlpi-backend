package org.monjasa.vlpi.util.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.monjasa.vlpi.domain.Exercise;
import org.monjasa.vlpi.dto.ExerciseDto;
import org.monjasa.vlpi.dto.ExerciseListItemDto;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.ExerciseRequest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.monjasa.vlpi.util.mapper.ExerciseMapperTest.ExerciseMapperTestConstants.*;

class ExerciseMapperTest {

    private ExerciseMapper exerciseMapper;

    @BeforeEach
    public void init() {
        this.exerciseMapper = Mappers.getMapper(ExerciseMapper.class);
    }

    @Test
    void toEntityValidRequestMappedToValidEntity() {
        ExerciseRequest exerciseRequest = new ExerciseRequest();
        exerciseRequest.setName(EXERCISE_NAME_VALID);
        exerciseRequest.setDescription(EXERCISE_DESCRIPTION_VALID);
        exerciseRequest.setModuleId(EXERCISE_MODULE_ID_VALID);

        Exercise exercise = exerciseMapper.toEntity(exerciseRequest);

        assertThat(exercise).isNotNull()
                .isExactlyInstanceOf(Exercise.class)
                .hasAllNullFieldsOrPropertiesExcept("name", "description", "isDeleted", "module")
                .extracting(
                        Exercise::getName,
                        Exercise::getDescription,
                        Exercise::getIsDeleted,
                        entity -> entity.getModule().getId()
                )
                .doesNotContainNull()
                .containsExactly(
                        EXERCISE_NAME_VALID,
                        EXERCISE_DESCRIPTION_VALID,
                        EXERCISE_IS_DELETED_BY_DEFAULT,
                        EXERCISE_MODULE_ID_VALID
                );
    }

    @Test
    void toEntityNullRequestMappedToNullEntity() {
        Exercise exercise = exerciseMapper.toEntity(null);

        assertThat(exercise).isNull();
    }

    @Test
    void toDtoValidEntityMappedToValidDto() {
        Exercise exercise = new Exercise();
        exercise.setId(EXERCISE_ID_VALID);
        exercise.setName(EXERCISE_NAME_VALID);
        exercise.setDescription(EXERCISE_DESCRIPTION_VALID);

        ExerciseDto exerciseDto = exerciseMapper.toDto(exercise);

        assertThat(exerciseDto).isNotNull()
                .isExactlyInstanceOf(ExerciseDto.class)
                .hasNoNullFieldsOrPropertiesExcept("tasks")
                .extracting(
                        ExerciseDto::getId,
                        ExerciseDto::getName,
                        ExerciseDto::getDescription
                )
                .doesNotContainNull()
                .containsExactly(
                        EXERCISE_ID_VALID,
                        EXERCISE_NAME_VALID,
                        EXERCISE_DESCRIPTION_VALID
                );
    }

    @Test
    void toDtoEntityWithoutDescriptionMappedToDtoWithoutDescription() {
        Exercise exercise = new Exercise();
        exercise.setId(EXERCISE_ID_VALID);
        exercise.setName(EXERCISE_NAME_VALID);

        ExerciseDto exerciseDto = exerciseMapper.toDto(exercise);

        assertThat(exerciseDto).isNotNull()
                .isExactlyInstanceOf(ExerciseDto.class)
                .hasNoNullFieldsOrPropertiesExcept("description", "tasks")
                .extracting(
                        ExerciseDto::getId,
                        ExerciseDto::getName,
                        ExerciseDto::getDescription
                )
                .containsNull()
                .containsExactly(
                        EXERCISE_ID_VALID,
                        EXERCISE_NAME_VALID,
                        null
                );
    }

    @Test
    void toDtoNullEntityMappedToNullDto() {
        ExerciseDto exerciseDto = exerciseMapper.toDto(null);

        assertThat(exerciseDto).isNull();
    }

    @Test
    void toListItemDtoValidEntityMappedToValidItemDto() {
        Exercise exercise = new Exercise();
        exercise.setId(EXERCISE_ID_VALID);
        exercise.setName(EXERCISE_NAME_VALID);
        exercise.setDescription(EXERCISE_DESCRIPTION_VALID);

        ExerciseListItemDto exerciseListItemDto = exerciseMapper.toListItemDto(exercise);

        assertThat(exerciseListItemDto).isNotNull()
                .isExactlyInstanceOf(ExerciseListItemDto.class)
                .hasNoNullFieldsOrProperties()
                .extracting(
                        ExerciseListItemDto::getId,
                        ExerciseListItemDto::getName,
                        ExerciseListItemDto::getDescription
                )
                .doesNotContainNull()
                .containsExactly(
                        EXERCISE_ID_VALID,
                        EXERCISE_NAME_VALID,
                        EXERCISE_DESCRIPTION_VALID
                );
    }

    @Test
    void toListItemDtoNullEntityMappedToNullListItemDto() {
        ExerciseListItemDto exerciseListItemDto = exerciseMapper.toListItemDto(null);

        assertThat(exerciseListItemDto).isNull();
    }

    @Test
    void toPersistableDtoValidEntityMappedToValidPersistableDto() {
        Exercise exercise = new Exercise();
        exercise.setId(EXERCISE_ID_VALID);

        PersistableDto persistableDto = exerciseMapper.toPersistableDto(exercise);

        assertThat(persistableDto).isNotNull()
                .isExactlyInstanceOf(PersistableDto.class)
                .hasNoNullFieldsOrProperties()
                .extracting(PersistableDto::getId)
                .isEqualTo(EXERCISE_ID_VALID);
    }

    @Test
    void toPersistableDtoNullEntityMappedToNullPersistableDto() {
        PersistableDto persistableDto = exerciseMapper.toPersistableDto(null);

        assertThat(persistableDto).isNull();
    }

    public static class ExerciseMapperTestConstants {

        public static final Long EXERCISE_ID_VALID = 1000L;

        public static final String EXERCISE_NAME_VALID = "exercise";

        public static final String EXERCISE_DESCRIPTION_VALID = "description";

        public static final long EXERCISE_MODULE_ID_VALID = 10L;

        public static final boolean EXERCISE_IS_DELETED_BY_DEFAULT = false;

    }
}