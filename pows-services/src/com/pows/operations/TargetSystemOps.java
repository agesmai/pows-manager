package com.pows.operations;

import com.pows.entity.PowsResponse;

public interface TargetSystemOps {

    PowsResponse create();

    PowsResponse getAll();

    PowsResponse getByCode(String code);

    PowsResponse searchByCode(String param);

    PowsResponse modify();

    PowsResponse delete();
}
