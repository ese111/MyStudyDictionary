# AndroidX
## AndroidX & Jetpack
- 안드로이드X와 제트팩은 다르다.
    - Jetpack
        - 개발자가 고품질 앱을 작성할때 쓸 수 있는 라이브러리, 도구, 가이드
    - androidX
        - Jetpack이 추구하는 가이드라인을 실체화한 라이브러리
## AndroidX 과거
### Support Library
- 앱 개발을 위한 라이브러리 모음
- 초기에는 리소스가 없는 간단한 모습
- 호환성 제공
#### AppCompat Them
- UI 호환성 레이어
- 머터리얼 디자인 사용을 위한 백보트 역할
- 새로운 기능을 채워줌
#### 단점
- 최소 지원 버전이 다름
- 내부 파악이 힘듬
- 단일 업데이트 불가
    - 종속성이 있는 라이브러리들도 업데이트를 해야함
#### v4, v7 의 의미
- 최소버전을 의미한다
### AndroidX 등장
## AndroidX View 호환성
- Compat
    - 구 버전에서 새롭게 추가되는 API와의 호환성
    - AppCompat
    - Material Design
- Standalone
    - 다양한 버전에서 단독적으로 사용하는 UI 라이브러리
    - Constraintlayout
## LayoutInflater
- [LayoutInflater](): xml을 객체화
- 