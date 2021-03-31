package org.jryyy.autoumatic.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SqlInfoException extends Exception {
    public SqlInfoException(String message) {
        super(message);
    }
}
