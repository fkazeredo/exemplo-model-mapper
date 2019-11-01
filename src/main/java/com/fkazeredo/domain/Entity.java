package com.fkazeredo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(of = "id")
@ToString
public abstract class Entity implements Serializable {

    protected Long id;
    protected Boolean enabled;

    public void enable() {
        if (!this.enabled) {
            this.enabled = true;
        }
    }

    public void disable() {
        if (this.enabled) {
            this.enabled = false;
        }
    }

}
