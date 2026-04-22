package com.dss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SampleEmp {
	private Integer eid;

	private String ename;

	public Integer getEid() {
		return eid;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + "]";
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public SampleEmp(Integer eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}

class FirstPredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {

		if (t > 2) {
			return true;
		} else {

			return false;
		}
	}

}

class SecondPredicate implements Predicate<String> {

	@Override
	public boolean test(String str) {

		if (str.startsWith("sh")) {
			return true;
		}
		return false;
	}

}

class BiPredicateExample implements BiPredicate<Integer, String> {

	@Override
	public boolean test(Integer t, String u) {

		if (t > 2 && u.startsWith("sh")) {
			return true;
		} else {
			return false;
		}
	}

}

public class PredicateExample {

	public static void main(String[] args) {

		SampleEmp emp1 = new SampleEmp(1, "sharath");

		SampleEmp emp2 = new SampleEmp(2, "shashi");

		SampleEmp emp3 = new SampleEmp(3, "manoj");

		SampleEmp emp4 = new SampleEmp(4, "arun");

		SampleEmp emp5 = new SampleEmp(5, "shankar");

		SampleEmp emp6 = new SampleEmp(6, "shanmukh");

		SampleEmp emp7 = new SampleEmp(7, "arjun");

		List<SampleEmp> sample_emp_list = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7);

		System.out.println(sample_emp_list);

		System.out.println("========================================");

		FirstPredicate p1 = new FirstPredicate();

		List<SampleEmp> list2 = sample_emp_list.stream().filter(e -> p1.test(e.getEid())).collect(Collectors.toList());

		System.err.println(list2);

		System.out.println("=================================");

		SecondPredicate p2 = new SecondPredicate();

		List<SampleEmp> list3 = sample_emp_list.stream().filter(e -> p2.test(e.getEname()))
				.collect(Collectors.toList());

		System.out.println(list3);

		System.out.println("==================================================");

		Predicate<SampleEmp> idGreater = e -> e.getEid() > 2;

		List<SampleEmp> list4 = sample_emp_list.stream().filter(idGreater).collect(Collectors.toList());

		System.out.println("list4 values  is....... :" + list4);

		System.out.println("======================================================");

		Predicate<SampleEmp> isnameStarts = e -> e.getEname().startsWith("sh");

		List<SampleEmp> list5 = sample_emp_list.stream().filter(isnameStarts).collect(Collectors.toList());

		System.out.println("list5  values is ...." + list5);

		System.out.println("================================================");

		Predicate<SampleEmp> andCondition = idGreater.and(isnameStarts);

		List<SampleEmp> list6 = sample_emp_list.stream().filter(andCondition).collect(Collectors.toList());

		System.out.println("list6 values are......" + list6);

		System.out.println("===============================");

		Predicate<SampleEmp> OrCondition = idGreater.or(isnameStarts);

		List<SampleEmp> list7 = sample_emp_list.stream().filter(OrCondition).collect(Collectors.toList());

		System.out.println(list7);

		System.out.println("===============================================");

		List<SampleEmp> list8 = sample_emp_list.stream().filter(isnameStarts.negate()).collect(Collectors.toList());

		System.out.println("negate values are...." + list8);

		System.out.println("=====================================");

		BiPredicateExample bp2 = new BiPredicateExample();

		List<SampleEmp> list9 = sample_emp_list.stream().

				filter(e -> bp2.test(e.getEid(), e.getEname())).collect(Collectors.toList());

		System.out.println("list 9 values are ...." + list9);

		System.out.println("==================================");

		BiPredicate<Integer, String> bp3 = (e1, e2) -> e1 > 2 && e2.startsWith("sh");

		List<SampleEmp> list10 = sample_emp_list.stream().

				filter(e -> bp3.test(e.getEid(), e.getEname())).collect(Collectors.toList());

		System.out.println("list 10 values are ......" + list10);

		System.out.println("====================================");

		List<SampleEmp> list11 = sample_emp_list.stream().

				filter(e -> predExample(e.getEid(), i -> i > 2)).collect(Collectors.toList());

		System.out.println("list 11 values are ......" + list11);

		System.out.println("================================");

		List<SampleEmp> list12 = other(list11);

		System.out.println("list12 values are ......" + list12);

		System.out.println("=================================================");

		List<SampleEmp> list_with_sample_emp = testPredicate(list12, i1 -> i1.getEname().startsWith("sh"));

		System.out.println("local values are......" + list_with_sample_emp);

		System.out.println("=========================================");

		Stream<SampleEmp> stream_emp = sample_emp_list.stream().filter(andCondition);

		System.out.println(sample_emp_list);

		System.out.println("==========================================");

		Consumer<Integer> obj = a -> System.out.println(a);

		obj.accept(10);

		System.out.println("=======================================");

		Consumer<SampleEmp> con = e -> System.out.println(e);

		sample_emp_list.forEach(con);

		System.out.println("======================================");

		Consumer<List<Integer>> modify = list -> {
			for (int i = 0; i < list.size(); i++)
				list.set(i, 2 * list.get(i));
		};

		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(3);

		modify.accept(list);

		System.out.println("modified list is ....." + list);

		System.out.println("========================================");

		Consumer<List<SampleEmp>> modify2 = l1 -> {

			for (SampleEmp e1 : l1) {
				if (e1.getEname().equals("sharath")) {
					e1.setEname("roman reigns");
				}
			}

		};

		List<SampleEmp> duplicateList = new ArrayList<SampleEmp>(sample_emp_list);

		modify2.accept(duplicateList);

		System.out.println(duplicateList);

		System.out.println("======================================");

		Consumer<SampleEmp> modify3 = l4 -> {

			if (l4.getEname().equals("shankar")) {
				l4.setEname("sharath");
			}

			System.out.println(l4);

		};

		duplicateList.forEach(modify3);

		System.out.println("===========================================");

		String first_value = duplicateList.stream().map(SampleEmp::getEname).filter(e -> e.startsWith("sha"))
				.findFirst().get();

		System.out.println(first_value);

		System.out.println("=======================");

		long count = duplicateList.stream().map(SampleEmp::getEname).filter(e -> e.startsWith("sha")).count();

		System.out.println("count with name starting with sh" + count);

		System.out.println("================================");

		duplicateList.stream().map(SampleEmp::getEname).sorted().forEach(e -> System.out.println(e));

		System.out.println("=========================================");

		Function<Integer, Double> half = a -> a / 2.0;

		System.out.println(half.apply(10));

		System.out.println("===============================");

		Function<Integer, String> convertToString = a -> a.toString();

		System.out.println(convertToString.apply(10));

		System.out.println(convertToString.apply(10).getClass().getName());

		System.out.println("========================");

		Function<String, String> concatStrings = a -> a.concat("kumar");

		duplicateList.stream().filter(e -> e.getEname().startsWith("sh")).

				map(SampleEmp::getEname).map(concatStrings).forEach(emp -> System.out.println(emp));

		System.out.println("=======================");

		Function<SampleEmp, SampleEmp> addStrings = ad1 ->

		{
			ad1.setEname(ad1.getEname().concat("kumar"));
			return ad1;
		};

		duplicateList.stream().filter(e -> e.getEname().startsWith("sh")).

				map(addStrings).forEach(emp -> System.out.println(emp));

		System.err.println("==================================");

		Function<Integer, Double> sample = a -> a / 2.0;

		// Now triple the output of half function
		sample = sample.andThen(a -> 3 * a);

		// Applying the function to get the result
		// and printing on console
		System.out.println(sample.apply(10));

		System.out.println("=======================================");

		Function<Integer, Double> sample2 = a -> a / 2.0;

		sample2 = sample2.compose(a -> 3 * a);

		// System.out.println(sample2.apply(5));

		System.out.println("=======================================");

		System.out.println("duplciateList......." + duplicateList);

		Function<String, String> g1 = a -> a.concat("123");

		Predicate<String> check = val -> val.startsWith("sh");

		List<String> list_of_String = duplicateList.stream().map(SampleEmp::getEname).map(g1).filter(check)
				.collect(Collectors.toList());

		System.out.println("list of string....." + list_of_String);

		System.out.println("=================================================================");

		String min_length = list_of_String.stream().max(Comparator.comparing(String::valueOf)).get();

		System.out.println("min length...." + min_length);

		System.out.println("==============================================");

		List<Integer> list_of_int = Arrays.asList(1, 1, 2, 3, 2, 3, 4, 5, 6, 4);

		Map<Integer, Long> count_map = list_of_int.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(count_map);

		System.out.println("=========================================================");

		Integer Second_repetitive = count_map.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey())
				.collect(Collectors.toList()).get(1);

		System.out.println("second repetive element is ......." + Second_repetitive);

		System.out.println("========================================");

		Map<Integer, Long> l_map = new LinkedHashMap<>();

		count_map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(e -> l_map.put(e.getKey(), e.getValue()));

		System.out.println(l_map);

		System.out.println("============================================");
	}

	static boolean predExample(Integer number, Predicate<Integer> predicate) {

		if (predicate.test(number)) {
			return true;
		} else {
			return false;
		}

	}

	public static Predicate<SampleEmp> lengthof = new Predicate<SampleEmp>() {

		@Override
		public boolean test(SampleEmp str) {

			if (str.getEname().startsWith("sh")) {
				return true;
			}
			return false;

		}

	};

	public static List<SampleEmp> other(List<SampleEmp> list) {
		Predicate<SampleEmp> containsM = p -> p.getEname().startsWith("ar");
		// String containsA = "And";
		Predicate<SampleEmp> outcome = lengthof.or(containsM);

		return list.stream().filter(outcome).collect(Collectors.toList());
	}

	public static List<SampleEmp> testPredicate(List<SampleEmp> list, Predicate<SampleEmp> predicate) {

		List<SampleEmp> list_values = new ArrayList<SampleEmp>();

		for (SampleEmp emp1 : list) {
			if (predicate.test(emp1)) {
				list_values.add(emp1);
			}
		}

		return list_values;

	}

}
