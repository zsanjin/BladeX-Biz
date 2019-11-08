/**
 * Copyright 2013-2015 JueYue (qrb.jueyue@gmail.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.example.poi.cache.file;

import cn.afterturn.easypoi.cache.manager.FileLoaderImpl;
import cn.afterturn.easypoi.cache.manager.IFileLoader;

public class MyFileLoader extends FileLoaderImpl implements IFileLoader {


	@Override
	public byte[] getFile(String url) {
		url = "doc/" + url;
		return super.getFile(url);
	}
}
