/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2017-09-05 21:06:36 UTC)
 * on 2017-09-20 at 15:12:05 UTC 
 * Modify at your own risk.
 */

package com.birdpeek.backend.helloworld.model;

/**
 * Model definition for HelloGreetingCollection.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the helloworld. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class HelloGreetingCollection extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<HelloGreeting> items;

  static {
    // hack to force ProGuard to consider HelloGreeting used, since otherwise it would be stripped out
    // see https://github.com/google/google-api-java-client/issues/543
    com.google.api.client.util.Data.nullOf(HelloGreeting.class);
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<HelloGreeting> getItems() {
    return items;
  }

  /**
   * @param items items or {@code null} for none
   */
  public HelloGreetingCollection setItems(java.util.List<HelloGreeting> items) {
    this.items = items;
    return this;
  }

  @Override
  public HelloGreetingCollection set(String fieldName, Object value) {
    return (HelloGreetingCollection) super.set(fieldName, value);
  }

  @Override
  public HelloGreetingCollection clone() {
    return (HelloGreetingCollection) super.clone();
  }

}
