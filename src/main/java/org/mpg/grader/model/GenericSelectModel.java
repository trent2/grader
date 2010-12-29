package org.mpg.grader.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.internal.OptionModelImpl;
import org.apache.tapestry5.ioc.services.PropertyAccess;
import org.apache.tapestry5.ioc.services.PropertyAdapter;
import org.apache.tapestry5.util.AbstractSelectModel;

public class GenericSelectModel<T> extends AbstractSelectModel {

	private PropertyAdapter labelFieldAdapter = null;

	private List<T> list;

	public GenericSelectModel(List<T> list, String labelField, PropertyAccess paccess) {
		if (list == null)
			list = new ArrayList<T>();
		if (labelField != null && !labelField.equalsIgnoreCase("null")) {
			if (!list.isEmpty()) {
				this.labelFieldAdapter = paccess.getAdapter(
						list.get(0).getClass()).getPropertyAdapter(labelField);
			}
		}
		this.list = list;
	}

	@Override
	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	@Override
	public List<OptionModel> getOptions() {
		List<OptionModel> optionModelList = new ArrayList<OptionModel>();
		for (T obj : list) {
			if (labelFieldAdapter == null) {
				optionModelList.add(new OptionModelImpl(nvl(obj) + "", obj));
			} else {
				optionModelList.add(new OptionModelImpl(nvl(labelFieldAdapter
						.get(obj)), obj));
			}
		}
		return optionModelList;
	}

	private String nvl(Object o) {
		if (o == null)
			return "";
		else
			return o.toString();
	}

}