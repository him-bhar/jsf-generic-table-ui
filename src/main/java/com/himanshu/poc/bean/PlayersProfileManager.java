/*
 * Copyright 2013 Himanshu Bhardwaj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/
package com.himanshu.poc.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.himanshu.poc.generictable.BasicDataTable;


@ManagedBean(name="playerProfileManager")
public class PlayersProfileManager extends BasicDataTable {

	private String[] headerRows;

	private Object[][] dataArr;

	@PostConstruct
	public void init() {
		headerRows = new String[] {"First Name", "Last Name", "E-mail"};
		dataArr = new Object[3][];
		dataArr[0] = new Object[] {"himanshu", "bhardwaj", "h.b@dk.com"};
		dataArr[1] = new Object[] {"sorabh", "solanki", "ss@gg.com"};
		dataArr[2] = new Object[] {"gaurav", "goel", "gg@dd.com"};
	}


	public String[] getHeaderRows() {
		return headerRows;
	}

	public void setHeaderRows(String[] headerRows) {
		this.headerRows = headerRows;
	}


	public Object[][] getDataArr() {
		return dataArr;
	}


	public void setDataArr(Object[][] dataArr) {
		this.dataArr = dataArr;
	}


}
