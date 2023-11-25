/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.nathan.learn.design.util;

import lombok.Data;

@Data
public class JobSubmitted extends DAGSchedulerEvent {
    private int jobId;

}