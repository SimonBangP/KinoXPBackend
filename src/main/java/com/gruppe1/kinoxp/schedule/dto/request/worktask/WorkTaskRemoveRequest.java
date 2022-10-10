package com.gruppe1.kinoxp.schedule.dto.request.worktask;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.gruppe1.kinoxp.schedule.dto.request.WorkDayRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class WorkTaskRemoveRequest {

    private WorkDayRequest workDayRequest;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;

}
