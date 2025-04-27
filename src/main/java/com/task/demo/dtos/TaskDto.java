package com.task.demo.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(String title, String description, Integer dueInDays, String category) { }
