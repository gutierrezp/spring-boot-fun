package com.arise.indexer;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.SolrInputField;

public class Apache2Solr {
	public static void main (String ...puta){
		
		SolrInputDocument document = new SolrInputDocument();
		
		List<String> shit1 = new ArrayList<>();
		shit1.add("hey");
		shit1.add("wey");
		shit1.add("sey");
		
		List<String> shit2 = new ArrayList<>();
		shit2.add("qwe");
		shit2.add("asd");
		shit2.add("zxc");
		
		List<String> shit3 = new ArrayList<>();
		shit3.add("tyu");
		shit3.add("ghj");
		shit3.add("bnm");
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("list1",shit1);
		map1.put("list2",shit2);
		map1.put("list3",shit3);
		map1.put("list4","shit4");
		map1.put("list5",new Date());
		
		for(Map.Entry<String, Object> ele:map1.entrySet()){
			SolrInputField field = new SolrInputField(ele.getKey());
			field.setValue(ele.getValue(), 1.0f);
			document.put(ele.getKey(), field);
		}
		System.out.println("documemnt is like: "+document);
	}

}
