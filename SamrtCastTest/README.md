# Smart Cast에 대한 실험 내용
인터페이스를 이용해서 상위 타입을 받고 다른 타입으로 변환이 가능할까? 에대한 실험

## 결론
안됨
interface BaseText를 상속 받아 StringText와 IntText를 만들고 버튼을 누르면 StringText를 IntText로 변경해보려 했는데 as로는 불간으했다.
