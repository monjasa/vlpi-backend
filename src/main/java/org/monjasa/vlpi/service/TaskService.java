package org.monjasa.vlpi.service;

import org.monjasa.vlpi.domain.Exercise;
import org.monjasa.vlpi.dto.common.PersistableDto;
import org.monjasa.vlpi.dto.request.TaskRequest;

public interface TaskService {

    PersistableDto create(Exercise exercise, TaskRequest taskRequest);

}
