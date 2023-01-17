/*
 * Copyright (c) 2022-2023 Stefan Psutka
 * All rights reserved
 */

package selfTesting;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class StrTokenizer {

    private final @NotNull String string;

    private final @NotNull String crunchBy;

    public StrTokenizer() {
        string = "Hello this is my String that I want to tokenize!";
        crunchBy = " ";
    }

    public static void main(String[] args) {
        StrTokenizer strTokenizer = new StrTokenizer();

        System.out.println(strTokenizer.Tokenizer());
    }

    /**
     * Own Tokenizer Implementation using {StringTokenizer}
     */
    public @NotNull ArrayList<String> Tokenizer() {
        ArrayList<String> al;
        al = new ArrayList<>();

        StringTokenizer st;
        st = new StringTokenizer(string, crunchBy);
        while (st.hasMoreTokens()) al.add((String) st.nextElement());

        return al;
    }
}