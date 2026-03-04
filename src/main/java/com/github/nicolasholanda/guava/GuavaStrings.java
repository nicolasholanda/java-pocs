package com.github.nicolasholanda.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

public class GuavaStrings {

    static void execute() {
        System.out.println(Strings.nullToEmpty(null));
        System.out.println(Strings.nullToEmpty("hello"));
        System.out.println(Strings.emptyToNull(""));
        System.out.println(Strings.emptyToNull("hello"));
        System.out.println(Strings.padStart("7", 3, '0'));
        System.out.println(Strings.padEnd("hi", 5, '!'));
        System.out.println(Strings.repeat("ab", 3));
        System.out.println(Strings.commonPrefix("foobar", "fooqaz"));
        System.out.println(Strings.commonSuffix("bazbar", "foobar"));
        System.out.println(Strings.isNullOrEmpty(null));
        System.out.println(Strings.isNullOrEmpty(""));
        System.out.println(Strings.isNullOrEmpty("x"));

        String joined = Joiner.on(", ").skipNulls().join("a", null, "b", "c");
        System.out.println("Joined: " + joined);

        String joinedMap = Joiner.on("; ").withKeyValueSeparator("=").join(
            java.util.Map.of("k1", "v1", "k2", "v2")
        );
        System.out.println("Joined map: " + joinedMap);

        Iterable<String> split = Splitter.on(",").trimResults().omitEmptyStrings().split("a, b,,  c, ");
        System.out.println("Split: " + split);

        java.util.Map<String, String> splitMap = Splitter.on(";").withKeyValueSeparator("=").split("a=1;b=2;c=3");
        System.out.println("Split map: " + splitMap);
    }
}

