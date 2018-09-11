package com.pows.operations;

import com.pows.entity.PowsResponse;

public interface PropertiesStoreOps {

    PowsResponse getAllBySystemCode();

    PowsResponse searchByCode();

    PowsResponse searchByName();

    PowsResponse add();

    PowsResponse modify();

    PowsResponse remove();
}
