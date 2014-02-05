/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.openstack.keystone.v2_0.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.beans.ConstructorProperties;

import org.jclouds.openstack.keystone.v2_0.config.CredentialType;
import org.jclouds.openstack.keystone.v2_0.config.CredentialTypes;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

/**
 * Api Key Credentials
 *
 * @see <a href="http://docs.openstack.org/api/openstack-identity-service/2.0/content/POST_authenticate_v2.0_tokens_Service_API_Api_Operations.html#d662e583"
/>
 * @author Adrian Cole
 */
@CredentialType(CredentialTypes.API_KEY_CREDENTIALS)
public class ApiKeyCredentials {

	   public static Builder<?> builder() {
	      return new ConcreteBuilder();
	   }

	   public Builder<?> toBuilder() {
	      return new ConcreteBuilder().fromApiKeyCredentials(this);
	   }

	   public static ApiKeyCredentials createWithUsernameAndApiKey(String username, String apiKey) {
	      return new ApiKeyCredentials(username, apiKey);
	   }

	   public abstract static class Builder<T extends Builder<T>>  {
	      protected abstract T self();

	      protected String username;
	      protected String apiKey;

	      /**
	       * @see ApiKeyCredentials#getUsername()
	       */
	      public T username(String username) {
	         this.username = username;
	         return self();
	      }

	      /**
	       * @see ApiKeyCredentials#getApiKey()
	       */
	      public T apiKey(String apiKey) {
	         this.apiKey = apiKey;
	         return self();
	      }

	      public ApiKeyCredentials build() {
	         return new ApiKeyCredentials(username, apiKey);
	      }

	      public T fromApiKeyCredentials(ApiKeyCredentials in) {
	         return this
	               .username(in.getUsername())
	               .apiKey(in.getApiKey());
	      }
	   }

	   private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
	      @Override
	      protected ConcreteBuilder self() {
	         return this;
	      }
	   }

	   private final String username;
	   private final String apiKey;

	   @ConstructorProperties({
	         "username", "apiKey"
	   })
	   protected ApiKeyCredentials(String username, String apiKey) {
	      this.username = checkNotNull(username, "username");
	      this.apiKey = checkNotNull(apiKey, "apiKey");
	   }

	   /**
	    * @return the username
	    */
	   public String getUsername() {
	      return this.username;
	   }

	   /**
	    * @return the apiKey
	    */
	   public String getApiKey() {
	      return this.apiKey;
	   }

	   @Override
	   public int hashCode() {
	      return Objects.hashCode(username, apiKey);
	   }

	   @Override
	   public boolean equals(Object obj) {
	      if (this == obj) return true;
	      if (obj == null || getClass() != obj.getClass()) return false;
	      ApiKeyCredentials that = ApiKeyCredentials.class.cast(obj);
	      return Objects.equal(this.username, that.username)
	            && Objects.equal(this.apiKey, that.apiKey);
	   }

	   protected ToStringHelper string() {
	      return Objects.toStringHelper(this)
	            .add("username", username).add("apiKey", apiKey);
	   }

	   @Override
	   public String toString() {
	      return string().toString();
	   }


}
