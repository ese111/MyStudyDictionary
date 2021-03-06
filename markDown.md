# 마크다운 문법
## 리드미를 위한 간단한 마크 다운 문법
----
## 헤더
헤더는 #으로 표기한다 #가 많아질수록 크기가 작아진다 #가 하나이면 제목으로 표기 되고 밑줄이 생긴다

```markdown
# h1
## h2
### h3
#### h4
##### h5 
###### h6
```
# h1
## h2
### h3
#### h4
##### h5 
###### h6

## 줄바꾸기
> 줄바꿈을 위해서는 공백를 두번 입력해야한다
엔터를 두번하면 문장 사이에 공백을 줄 수 있다.

```markdown
그냥 엔터는 
줄바꿈이 
되지 않는다
```


그냥 엔터는 
줄바꿈이 
되지 않는다


```markdown
엔터를  
두번해야

줄이 바꿔진다
```
엔터를

두번해야

줄이 바꿔진다

## 인용구
인용구는 '>'로 사용한다
'> >"를 중복하면 여러개를 겹쳐서 쓸 수 있다

```markdown
> 인용구는
> > 이렇게 사용합니디.
```
> 인용구는
> > 이렇게 사용합니디.

## 구분선
글을 쓸때 구분선은 가독성을 위해 중요하다
마크다운에서 구분선은 여러가지 방법이 있다
'------'은 위에 글씨를 헤더로 해준다
```markdown
구분선
------
구분선
- - - - - - - - 
구분선
-  -  -  -  -  -

구분선
*****
구분선
*********
구분선
* * * * *
구분선

```
구분선
------
구분선
- - - - - - - - 
구분선
-  -  -  -  -  -

구분선
*****
구분선
*********
구분선
* * * * *
구분선


## 번호
번호를 부여할 수도 있다

```markdown
1. 첫번째
2. 두번째
3. 세번째
```
1. 첫번째
2. 두번째
3. 세번째

## 불릿
불릿은 **들여쓰기**가 가능하다

```markdown
* 이게
    * 불릿
        * 입니다.
- 이게
    - 불릿
        - 입니다.
+ 이게
    + 불릿
        + 입니다.        
```
* 이게
    * 불릿
        * 입니다.
- 이게
    - 불릿
        - 입니다.
+ 이게
    + 불릿
        + 입니다.

## 텍스트 변환
**별 두개** 또는 __언더바 두개를__ 문장 앞뒤로 넣으면 굵게 표현되고

_언더바_ 하나로 감싸면 이텔릭체

***별 세개*** 또는 ***언더바*** 세개로 감싸면 굵게 기울어진다

*별을* 하나로 감싸면 기울어진다

~~취소선은~~ 물결표시를 쓰면된다

```markdown
**별 두개** 또는 __언더바 두개를__ 문장 앞뒤로 넣으면 굵게 표현되고

_언더바_ 하나로 감싸면 이텔릭체

***별 세개*** 또는 ***언더바*** 세개로 감싸면 굵게 기울어진다

*별을* 하나로 감싸면 기울어진다

~~취소선은~~ 물결표시를 쓰면된다

```

## 하이퍼 링크
1. 하이퍼링크는 <>안에 링크를 넣는다 
2. []안에 링크명을 쓰고 ()안에 링크를 넣는다 
3. []안에 링크명을 쓰고 (링크,"설명")을 쓰면 링크 설명까지 표기할 수 있다 [깃헙](https://github.com/ese111/MyStudyDirectoryDictionary, "MSD")
4. ()안에 페이지내의 제목을 쓰면 목차 링크 설정 가능
```markdown
<https://github.com/ese111/MyStudyDirectoryDictionary>

[깃헙](https://github.com/ese111/MyStudyDirectoryDictionary)

[깃헙](https://github.com/ese111/MyStudyDirectoryDictionary, "MSD")

[헤더](#헤더)
[줄바꾸기](#줄바꾸기)
[인용구](#인용구)
[구분선](#구분선)
[번호](#번호)
[불릿](#불릿)
[텍스트 변환](#텍스트_변환)
[하이퍼 링크](#하이퍼_링크)
[이미지](#이미지)
```
<https://github.com/ese111/MyStudyDirectoryDictionary>

[깃헙](https://github.com/ese111/MyStudyDirectoryDictionary)

[깃헙](https://github.com/ese111/MyStudyDirectoryDictionary, "MSD")

[헤더](#헤더)

[줄바꾸기](#줄바꾸기)

[인용구](#인용구)

[구분선](#구분선)

[번호](#번호)

[불릿](#불릿)

[텍스트 변환](#텍스트_변환)

[하이퍼 링크](#하이퍼_링크)

[이미지](#이미지)

## 이미지
1. git Repository에서 issue로 들어간다
<img width="1347" alt="스크린샷 2022-01-08 오후 11 52 29" src="https://user-images.githubusercontent.com/79190824/148648910-8c04c68c-0511-4f4e-ba26-b8102d673b60.png">


2. new issue 선택
<img width="1311" alt="스크린샷 2022-01-08 오후 11 54 04" src="https://user-images.githubusercontent.com/79190824/148648947-dca4d42f-8074-41f7-95a5-8b063d9be2cc.png">


3. 올리고 싶은 이미지를 드래그한다
<img width="1311" alt="스크린샷 2022-01-08 오후 11 54 13" src="https://user-images.githubusercontent.com/79190824/148649022-4c1a1424-2963-4b83-a6ad-3eb3ac9a0536.png">


4. 생성된 링크를 붙여넣기한다
    + css를 통해서 크기 조정도 가능
<img width="1432" alt="스크린샷 2022-01-08 오후 11 58 49" src="https://user-images.githubusercontent.com/79190824/148649015-953f137a-1210-44b9-af23-0e5f17954242.png">


```markdown
<img width="1347" alt="스크린샷 2022-01-08 오후 11 52 29" src="https://user-images.githubusercontent.com/79190824/148648819-acab919a-3d29-47f5-9eb3-d2638d1c209f.png">
```
<img width="1347" alt="스크린샷 2022-01-08 오후 11 52 29" src="https://user-images.githubusercontent.com/79190824/148648819-acab919a-3d29-47f5-9eb3-d2638d1c209f.png">

5. 코드 박스
```markdown

    ```kotlin
    fun main() = println("kotlin")

    ```

    ~~~
    코드 블럭
    ~~~

    ```
    코드 블럭
    ```

```

```kotlin
fun main() = println("kotlin")

```

~~~
코드 블럭
~~~

```
코드 블럭
```

------
## 참고
https://blog.naver.com/ycpiglet/222307838439

https://kyeoneee.tistory.com/56