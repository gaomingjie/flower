/**
 * Copyright © 2019 同程艺龙 (zhihui.li@ly.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 */
package com.ly.train.flower.common.exception;

/**
 * @author leeyazhou
 * 
 */
public class FlowerException extends RuntimeException {

  private static final long serialVersionUID = 6532232062131720108L;

  public FlowerException() {
    super();
  }

  public FlowerException(String message) {
    super(message);
  }

  public FlowerException(String message, Throwable cause) {
    super(message, cause);
  }

  public FlowerException(Throwable cause) {
    super(cause);
  }

  @Override
  public void printStackTrace() {
    // TODO Auto-generated method stub
    super.printStackTrace();
  }
}
