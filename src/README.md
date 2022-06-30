### _7662_이중_우선순위_큐
Java에 Binary Search Tree는 존재하지 않지만, 더 좋은 TreeMap이 있다(Red Black Tree).  
TreeMap 값 수정 시 주의해야할 점 : TreeMap 내부 함수를 이용해 얻은 entry에  `setValue` 함수를 적용하면 안 된다! 이렇게 얻은 entry는 단순한 snapshot이기 때문이다.

*All Map.Entry pairs returned by methods in this class and its views represent snapshots of mappings at the time they were produced. They do not support the Entry.setValue method. (Note however that it is possible to change mappings in the associated map using put.)*  
[Java11 TreeMap Doc 링크](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/TreeMap.html)
