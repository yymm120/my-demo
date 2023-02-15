package com.demo03error;

import java.util.function.Consumer;

public interface Result<Ok, Err> {

    Ok unwrapOrElse(Consumer<Err> elseFunction);

}




