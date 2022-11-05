package com.devcloudy.exampleservice.validation;


import javax.validation.ValidationException;

public class EditPostsAccessDeniedException extends ValidationException {

    private static final String errorMessage = "Текущий пользователь не может редактировать посты";

    public EditPostsAccessDeniedException() {
        super(errorMessage);
    }

}
