
# JVM Garbage Collection


## Garbage Collection?

- 자동 메모리 관리를 수행하는 프로세스

- 힙에서 더 이상 사용되지 않는 개체를 삭제해서 메모리 확보


## JVM Heap

- Young Generation

- 새로 생성된 객체가 Young Generation에서 시작

- 모든 새로운 개체가 시작되는 Eden 공간

- 1개의 가비지 수집 주기에서 살아남은 후 개체가 Eden에서 이동되는 두 개의 Survivor 공간으로 세분화됩니다.

- Young Generation의 GC는 Minor GC

- Old Generation

- 수명이 긴 개체는 결국 Young Generation에서 Old Generation으로 이동

- Old Generation의 GC는 Major GC

- Permanent Generation

- 클래스 및 메서드와 같은 메타데이터는 Permanent Generation에 저장

- 더 이상 사용되지 않는 클래스는 Permanent Generation에서 가비지 수집


## 동작 방식

- Young Generation과 Old Generation이 구조가 달라서 세부 방식은 다름

- 기본적으로 2가지 공통 단계

- 1. Stop the World

- GC를 실행할 때 JVM이 애플리케이션의 실행을 멈춤다

- GC를 실행하는 쓰레드 이외 모든 쓰레드가 중단

- GC 완료 후 재개

- GC의 성능 개선을 하면 보통 stop the world의 시간을 줄이는 작업

- 2. Mark and Sweep

- Mark: 사용되는 메모리와 그렇지 않은 메모리 식별 작업

- sweep: Mark 단계에서 사용되지 않음으로 식별된 메모리로 해제

1. Stop the World로 작업을 중단

2. C는 스택의 모든 변수 또는 Reachable 객체를 스캔하면서 각각이 어떤 객체를 참고하고 있는지 탐색

3. Mark

4. Sweep


- ### Minor GC

- Young Generation 구조

- 1개의 Eden과 2개의 Surviveor 영역으로 나눠짐

- Eden: 새로 생성된 객체가 할당

- Surviveor: 1번 이상의 GC에서 살아남은 객체

- Eden이 꽉 차면 Minor GC 발생

- 살아남은 객체는 Survivor로 이동

- 1개의 Survivor에만 객체가 있어야 한다.

- Survivor이 다 차면 Eden에서 살아남은 객체는 다른 Survivor에 저장이 되고 원래 있던 객체는 Old Generation으로 넘어간다.

- Young Generation은 보통 Old Generation 보다 공간이 작기 때문에 Minor GC는 프로그램에 그렇게 영향이 없음

- ### Major GC

- Major GC는 Young Generation에서 계속 객체가 이동되어 Old Generation의 메모리가 부족해지면 발생한다.

- Young Generation은 보통 Old Generation 보다 공간이 작기 때문에

- Old Generation은 공간이 크고 YOUNG Generation까지 참조가 가능해서 Major GC는 시간이 오래 걸린다



﻿