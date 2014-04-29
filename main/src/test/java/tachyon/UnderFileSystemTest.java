/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tachyon;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link UnderFileSystem}
 */
public final class UnderFileSystemTest {

  @Test
  public void parseTest() {
    Pair<String, String> result = UnderFileSystem.parse(null);
    Assert.assertEquals(result, null);
  }

  @Test
  public void parseTest2() {
    Pair<String, String> result = UnderFileSystem.parse("");
    Assert.assertEquals(result, null);
  }

  @Test
  public void parseTest3() {
    Pair<String, String> result = UnderFileSystem.parse("anythingElse");
    Assert.assertEquals(result, null);
  }

  @Test
  public void parseTest4() {
    Pair<String, String> result = UnderFileSystem.parse("/path");
    Assert.assertEquals(result.getFirst(), "/");
    Assert.assertEquals(result.getSecond(), "/path");
  }

  @Test
  public void parseTest5() {
    Pair<String, String> result = UnderFileSystem.parse("file:///path");
    Assert.assertEquals(result.getFirst(), "/");
    Assert.assertEquals(result.getSecond(), "/path");
  }

  @Test
  public void parseTest6() {
    Pair<String, String> result = UnderFileSystem.parse("tachyon://localhost:19998");
    Assert.assertEquals(result.getFirst(), "tachyon://localhost:19998");
    Assert.assertEquals(result.getSecond(), "/");
  }

  @Test
  public void parseTest7() {
    Pair<String, String> result = UnderFileSystem.parse("tachyon://localhost:19998/");
    Assert.assertEquals(result.getFirst(), "tachyon://localhost:19998");
    Assert.assertEquals(result.getSecond(), "/");
  }

  @Test
  public void parseTest8() {
    Pair<String, String> result = UnderFileSystem.parse("tachyon://localhost:19998/path");
    Assert.assertEquals(result.getFirst(), "tachyon://localhost:19998");
    Assert.assertEquals(result.getSecond(), "/path");
  }

  @Test
  public void parseTest9() {
    Pair<String, String> result = UnderFileSystem.parse("tachyon-ft://localhost:19998/path");
    Assert.assertEquals(result.getFirst(), "tachyon-ft://localhost:19998");
    Assert.assertEquals(result.getSecond(), "/path");
  }

  @Test
  public void parseTest10() {
    Pair<String, String> result = UnderFileSystem.parse("hdfs://localhost:19998/path");
    Assert.assertEquals(result.getFirst(), "hdfs://localhost:19998");
    Assert.assertEquals(result.getSecond(), "/path");
  }
}
