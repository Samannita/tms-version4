package com.cg.tms.dao;


import java.util.List;

import com.cg.tms.entity.Center;

public class FetchCentersImpl implements IFetchAllDetails<Center> {

	@Override
	public List<Center> retrieveAll() {
	 List<Center> centers ;
	 centers= DatabaseCollection.center;
		return centers;
	}

	@Override
	public Center retrieve(String id) {
		List<Center> centers;
		Center center=null;
		centers=retrieveAll();
		for (Center c: centers) {
			if (c.getCenterId().equals(id)) {
				center=c;
				break;
			}
		}
		return center;
	}

}
