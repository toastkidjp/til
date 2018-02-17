/*
 * Copyright (c) 2018 toastkidjp.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html.
 */
package jp.toastkid.til;

import android.text.TextUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class TextUtilsTest {

    @Test
    public void check_concat() {
        assertEquals("abc", TextUtils.concat("a", "b", "c"));
        assertEquals(0, TextUtils.concat().length());
    }

    @Test
    public void check_expandTemplate() {
        assertEquals("Ice cream is cool.", TextUtils.expandTemplate("^1 is ^2.", "Ice cream", "cool").toString());
        assertEquals("cool is Ice cream.", TextUtils.expandTemplate("^2 is ^1.", "Ice cream", "cool").toString());
        assertEquals("Ice cream is Ice cream.", TextUtils.expandTemplate("^1 is ^1.", "Ice cream", "cool").toString());
        assertEquals("Ice cream is cool.", TextUtils.expandTemplate("Ice cream is cool.").toString());
    }

    @Test
    public void check_isDigitsOnly() {
        assertTrue(TextUtils.isDigitsOnly("123456"));
        assertFalse(TextUtils.isDigitsOnly("123g"));
        assertTrue(TextUtils.isDigitsOnly(""));
        // TextUtils.isDigitsOnly(null);
    }

    @Test
    public void check_htmlEncode() {
        assertEquals("&lt;a&gt;", TextUtils.htmlEncode("<a>"));
        assertEquals("", TextUtils.htmlEncode(""));
        //assertEquals(null, TextUtils.htmlEncode(null));
    }

    @Test
    public void check_join() {
        assertEquals("abcde", TextUtils.join("", new String[]{"a", "b", "c", "d", "e"}));
        assertEquals("a,b,c,d,e", TextUtils.join(",", new String[]{"a", "b", "c", "d", "e"}));
        assertEquals("anullbnullcnulldnulle", TextUtils.join(null, new String[]{"a", "b", "c", "d", "e"}));
    }

    @Test
    public void check_split() {
        assertEquals("[to, be, or, not, to]", Arrays.toString(TextUtils.split("to/be/or/not/to", "/")));
    }

    @Test
    public void check_substring() {
        assertEquals("om", TextUtils.substring("tomato", 1, 3));
        // TextUtils.substring(null, 1, 3);
        // TextUtils.substring("tomato", -1, 3);
        // TextUtils.substring("tomato", 2, 30);
    }

    @Test
    public void check_replace() {
        assertEquals("cbi", TextUtils.replace("abc", new String[]{"a", "c"}, new CharSequence[]{"c", "i"}).toString());
        assertEquals("cbida", TextUtils.replace("abcda", new String[]{"a", "c"}, new CharSequence[]{"c", "i"}).toString());
        assertEquals("cbida", TextUtils.replace("abcda", new String[]{"c", "a"}, new CharSequence[]{"i", "c"}).toString());
        assertEquals("cbida", TextUtils.replace("abcda", new String[]{"c", "a"}, new CharSequence[]{"i", "c", "e"}).toString());
        assertEquals("cbida", TextUtils.replace("abcda", new String[]{"c", "a", "e"}, new CharSequence[]{"i", "c"}).toString());
    }

    @Test
    public void check_getTrimmedLength() {
        assertEquals(1, TextUtils.getTrimmedLength("a  "));
        assertEquals(4, TextUtils.getTrimmedLength("a  b"));
        assertEquals(4, TextUtils.getTrimmedLength("  a  b  "));
        assertEquals(0, TextUtils.getTrimmedLength(""));
        //assertEquals(0, TextUtils.getTrimmedLength(null));
    }

    @Test
    public void check_SimpleStringSplitter() {
        TextUtils.SimpleStringSplitter splitter = new TextUtils.SimpleStringSplitter('-');
        splitter.setString("a-b-c");
        for (;splitter.hasNext();) {
            System.out.println(splitter.next());
        }
        splitter.setString("9");
        for (;splitter.hasNext();) {
            System.out.println(splitter.next());
        }
        // splitter.setString(null);
    }
}