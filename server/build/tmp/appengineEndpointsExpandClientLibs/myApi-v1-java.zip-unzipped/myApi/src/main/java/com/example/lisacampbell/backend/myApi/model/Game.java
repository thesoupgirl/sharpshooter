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
 * on 2015-07-26 at 06:02:38 UTC 
 * Modify at your own risk.
 */

package com.example.lisacampbell.backend.myApi.model;

/**
 * Model definition for Game.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the myApi. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Game extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer globalKillCount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean inProgress;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private JsonMap players;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getGlobalKillCount() {
    return globalKillCount;
  }

  /**
   * @param globalKillCount globalKillCount or {@code null} for none
   */
  public Game setGlobalKillCount(java.lang.Integer globalKillCount) {
    this.globalKillCount = globalKillCount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getInProgress() {
    return inProgress;
  }

  /**
   * @param inProgress inProgress or {@code null} for none
   */
  public Game setInProgress(java.lang.Boolean inProgress) {
    this.inProgress = inProgress;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public JsonMap getPlayers() {
    return players;
  }

  /**
   * @param players players or {@code null} for none
   */
  public Game setPlayers(JsonMap players) {
    this.players = players;
    return this;
  }

  @Override
  public Game set(String fieldName, Object value) {
    return (Game) super.set(fieldName, value);
  }

  @Override
  public Game clone() {
    return (Game) super.clone();
  }

}
