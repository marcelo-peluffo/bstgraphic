package com.marcelo;

import java.awt.Font;

public class Config {
    public static final String DEFAULT_WINDOW_NAME = "BST Graphic";
    public static final String PROMPT = "Enter a number to add to the BST Graphic";
    public static final String PROMPT_FONT_NAME = "Consolas";
    public static final Font PROMPT_FONT_OBJECT;
    public static final int PROMPT_X = 650;
    public static final int PROMPT_Y = 150;
    public static final int PROMPT_FONT_SIZE = 25;
    public static final int PROMPT_STYLE = 25;
    public static final int DEFAULT_WIDTH = 1920;
    public static final int DEFAULT_HEIGHT = 1080;

    static {
        PROMPT_FONT_OBJECT = new Font(PROMPT_FONT_NAME, PROMPT_STYLE, PROMPT_FONT_SIZE);
    }
}
