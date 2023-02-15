package com.demo03error;

import java.util.function.Consumer;

public class PixelResult<Ok, Err> implements Result<Ok, Err> {
    private Ok successData;
    private Err errorData;
    private boolean isError;

    public PixelResult(Ok successData, Err errorData, boolean isError) {
        this.successData = successData;
        this.errorData = errorData;
        this.isError = isError;
    }


    public static <Ok, Err> PixelResult<Ok, Err> failureWrap(Err errorData) {
        return new PixelResult<>(null, errorData, true);
    }


    public static <Ok, Err> PixelResult<Ok, Err> successWrap(Ok successData) {
        return new PixelResult<>(successData, null, false);
    }


    @Override
    public Ok unwrapOrElse(Consumer<Err> elseFunction) {
        Ok result = null;
        if (isError || errorData != null || successData == null) {
            elseFunction.accept(errorData);
        } else {
            result = getSuccessData();
        }
        return result;
    }



    public Ok getSuccessData() {
        return successData;
    }

    public void setSuccessData(Ok successData) {
        this.successData = successData;
    }

    public Err getErrorData() {
        return errorData;
    }

    public void setErrorData(Err errorData) {
        this.errorData = errorData;
    }


    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }
}
