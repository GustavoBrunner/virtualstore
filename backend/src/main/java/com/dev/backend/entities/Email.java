package com.dev.backend.entities;

import org.springframework.beans.factory.annotation.Value;

public record Email(String receiver, String title, String message) { }