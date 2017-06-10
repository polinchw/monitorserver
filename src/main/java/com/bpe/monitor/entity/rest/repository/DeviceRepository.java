package com.bpe.monitor.entity.rest.repository;

import com.bpe.monitor.entity.*;
import org.springframework.data.repository.*;
import org.springframework.data.rest.core.annotation.*;

/**
 * Created by polinchw on 6/10/17.
 */
@RepositoryRestResource(collectionResourceRel = "device", path = "device")
public interface DeviceRepository extends PagingAndSortingRepository<Device, Long> {
}
