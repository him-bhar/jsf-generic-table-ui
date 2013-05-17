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
package com.himanshu.poc.generictable;

import java.util.Arrays;
import java.util.List;

public abstract class BasicDataTable implements DataTableInterface {

	String[] headerRows;
	Object[][] dataArr;
	int currentPage;
	int numberOfPages;
	int rowsPerPage;
	int[] rowsPerPageOptions;
	Object[][] rowsToDisplay;

	@Override
	public abstract String[] getHeaderRows();

	@Override
	public abstract Object[][] getDataArr();

	public void setHeaderRows(String[] headerRows) {
		this.headerRows = headerRows;
	}

	public void setDataArr(Object[][] dataArr) {
		this.dataArr = dataArr;
	}

	@Override
	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public int getNumberOfPages() {
		return this.numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Override
	public int getRowsPerPage() {
		return this.rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	@Override
	public int[] getRowsPerPageOptions() {
		return this.rowsPerPageOptions;
	}

	public void setRowsPerPageOptions(int[] rowsPerPageOptions) {
		this.rowsPerPageOptions = rowsPerPageOptions;
	}

	public Object[][] getRowsToDisplay() {
		return rowsToDisplay;
	}

	public void setRowsToDisplay(Object[][] rowsToDisplay) {
		this.rowsToDisplay = rowsToDisplay;
	}

	public void displayData() {
		List<Object[]> data = Arrays.asList(getDataArr());
		List<Object[]> listToDisplay;

		if ( (data.size() > ((rowsPerPage*currentPage)+1)) &&  (data.size() > (rowsPerPage*(currentPage+1))) ) {
			listToDisplay = data.subList(rowsPerPage*currentPage, rowsPerPage*(currentPage+1) );
		} else if ( (data.size() > ((rowsPerPage*currentPage)+1)) &&  (data.size() <= (rowsPerPage*(currentPage+1))) ) {
			listToDisplay = data.subList(rowsPerPage*currentPage, data.size() );
		} else {
			listToDisplay = data;
		}
		listToDisplay.toArray(rowsToDisplay);
	}
}
