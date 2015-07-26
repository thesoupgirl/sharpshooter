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
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-07-16 18:28:29 UTC)
 * on 2015-07-26 at 13:07:57 UTC 
 * Modify at your own risk.
 */

package com.example.lisacampbell.backend.myApi.model;

/**
 * Model definition for TargetResponse.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the myApi. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class TargetResponse extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private UUID id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String name;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String pictureByteString;

  /**
   * @return value or {@code null} for none
   */
  public UUID getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public TargetResponse setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * @param name name or {@code null} for none
   */
  public TargetResponse setName(java.lang.String name) {
    this.name = name;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPictureByteString() {
    return pictureByteString;
  }

  /**
   * @param pictureByteString pictureByteString or {@code null} for none
   */
  public TargetResponse setPictureByteString(java.lang.String pictureByteString) {
    this.pictureByteString = pictureByteString;
    return this;
  }

  @Override
  public TargetResponse set(String fieldName, Object value) {
    return (TargetResponse) super.set(fieldName, value);
  }

  @Override
  public TargetResponse clone() {
    return (TargetResponse) super.clone();
  }

}
