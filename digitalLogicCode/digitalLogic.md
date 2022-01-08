# 논리 회로


## 논리회로?

논리회로는 불 대수를 물리적 장치로 구현해 놓은 것을 말한다.
논리 연산을 수행하여 논리적 출력 값을 얻는 전자회로인 것이다.
 
## 논리게이트

<img width="607" alt="스크린샷 2022-01-07 오후 8 04 52" src="https://user-images.githubusercontent.com/79190824/148535261-6b0c6a90-a294-49a2-9fc3-bd930e54f711.png">


AND
A	B	OUT
0	0	0
1	0	0
0	1	0
1	1	1
AND는 모든 값이 true(1) 여야 true이다.

```kotlin
fun AND(bitA: Boolean, bitB: Boolean) = if(bitA==true&&bitB==true) true else false
```
 
OR
A	B	OUT
0	0	0
1	0	1
0	1	1
1	1	1
OR은 하나라도 true면 true이다.

```kotlin
fun OR(bitA: Boolean, bitB: Boolean) = if(bitA==true || bitB==true) true else false

```

NOT
 
A	OUT
0	1
1	0
NOT은 값은 반전시킨다.
```kotlin
fun NOT(bit: Boolean) = !bit

```
XOR
 
A	B	OUT
0	0	0
1	0	1
0	1	1
1	1	0
XOR은 두 값이 같으면 false 다르면 true다.
```kotlin
fun NAND(bitA: Boolean, bitB: Boolean) = AND(NOT(bitA), NOT(bitB))

``` 
NAND
 
A	B	OUT
0	0	1
1	0	1
0	1	1
1	1	0
NAND는 NOT + AND라고 생각하면 쉽다.
값을 반전시키고 AND를 사용한 것 과 같다.
두 값이 true면 false고 이외에는 true다.
```kotlin
fun XOR(bitA: Boolean, bitB: Boolean) = if(bitA != bitB) true else false

``` 
NOR
 
A	B	OUT
0	0	1
1	0	0
0	1	0
1	1	0
NOR은 NOT + OR을 생각하면 좋다.
두 값이 false면 true고 이외에는 false다.
```kotlin
fun XOR(bitA: Boolean, bitB: Boolean) = OR(NOT(bitA), NOT(bitB))

```
