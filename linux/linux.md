# 리눅스
## 목차
#### + [리눅스란?](#리눅스란?)
#### + [리눅스의 역사](#리눅스의-역사)
#### + [리눅스의 구조](#리눅스의-구조)
#### + 가상 환경에서 리눅스 실행
#####   + [Virtual Box](#Virtual-Box-설치)
------------------------
## 리눅스란?
리눅스는 운영체제 중 하나로, 다중 사용자, 다중 작업을 지원하는 오픈소스 네트워크 운영체제이다.


## 리눅스의 역사
MIT 인공지능 연구소의 연구원으로 ITS 프로젝트에 참여하였던 리차드 스톨먼(Richard Stollman) 그는 소스를 공개하지 못하도록 하는 분위기와 기술을 상업화하려는 것이 너무나 싫었디.

그는 모두에게 공개된 UNIX 시스템을 위해 GNU(GNU is Not Unix) 프로젝트를 시작하게 되었다.  
GNU 프로젝트로 개발된 에디터인 Emacs에 대한 사용자들의 관심이 높아지면서, 스톨먼은 GNU프로젝트 운영을 위해 FSF(Free Software Foundation, 자유 소프트웨어재단)을 설립했다.  
개발이 진행된 프로그램들은 GNU프로그램들의 배포 라이센스인 GPL하에서 판매되었으며, 판매 수익은 프로젝트를 운영하는데 사용되었다.   
모든 GNU프로젝트는 FSF를 중심으로 진행되어 갔다.  
GNU 프로젝트는 거의 완성단계였으나 GNU 커널의 개발은 좀처럼 진척되지 않았다.  


한편 1991년 핀란드의 헬싱키 사는 대학생 리누스 토발즈에 의해 GNU시스템에 적합한 커널이 개발되고 있었는데, 이것이 바로 리눅스였다.
당시 21살의 대학생이었던 리누스는, 앤디 타넨바움교수가 학생들의 학습을 주 목적으로 개발한 미닉스(MINIX)를 사용하던 중, 유닉스와 호환되는 공개된 운영체제의 개발 계획을 MINIX 사용자 모임에 발표하였다.   
초기의 리눅스는 이식성이 고려되지 않은, 다만 i386계열에서 운영되는 유닉스 호환 운영체제를 목표로 하는 프로젝트였다.  
초기 버전 0.01은 가장 기본적인 커널만을 포함하고 있었으며, 실행조차 되지 않는 수준이었다.  
얼마 후 리눅스 공식 버전인 0.02가 발표되었는데, bash(GNU Bourne Again Shell)와 gcc(GNU C 컴파일러)정도가 실행될 수 있는 수준이었다.  
GNU커널로 개발 중이던 Hurd의 개발이 순조롭지 않았던, 스톨먼과 FSF는 유닉스 커널과 호환 가능한 커널인 리눅스를 GNU시스템의 커널로 채택하기로 했고 그렇게 리눅스가 시작되었다...

## 리눅스의 구조
### 1. 커널
+ 프로그램 실행과정에서 가장 핵심적인 연산이 이루어 지는 부분
+ 코어, 리눅스라고 부른다
+ 하드웨어를 직접 제어하고, 프로세스 관리, 메모리 관리, 파일시스템 관리등을 수행
+ 쉘에서 명령하는 작업을 수행하고 결과를 쉘로 보내는 일을 수행

### 2. 쉘(shell)
+ 명령을 해석해서 커널에게 전달, 실행
    + 사용자가 입력한 문자열을 해석하고 행당 명령어를 찾는아 커널에 요청
+ 수행 결과를 유저에게 알려줌
+ 쉘의 종류
1. Bourne Shell (sh)
    - Bourne Shell 은 1974년 'Stephen Bourne'  (스티브 본) 이 개발 최초의 쉘(Shell)
    - 대부분의 리눅스에 기본적으로 설치
    - 설치 위치는 '/bin/sh'  
 2. C Shell (csh)
    - 1978년 'Bill Joy' (빌 조이) 가 개발한 쉘(Shell)
    - C 언어를 기반으로 만든 Shell
    - 설치 위치는 '/bin/csh' 이다.
 3. tee-see-Shell (tcsh)
    - 'Carnegie Mellon University' (카네기 멜런 대학교) 의 학생들이 개발
    - C Shell 에서 명령 행 완성과 명령 행 편집 기능을 추가한 것
    - 초기 맥 OS X 는 tcsh를 기본 셸로 포함
    - 설치 위치는 '/bin/tcsh'
 4. Z Shell (zsh)
    - 'Paul Falstad' (폴 폴스타드) 가 1990년 대학교에 재학 중 일 때 첫 버전을 작성
    - 개선 사항들이 갖추어진 확장형 Bourne Shell
    - 설치 위치는 '/bin/zsh' 이다.
 5. Bourne-again shell (bash)
    - 지금 현 시대에 가장 많이 쓰이는 Shell
    - GNU 프로젝트를 위해 'Brian Fox' (브라이언 폭스) 가 작성한 쉘(Shell)
    - GNU 운영체제와 리눅스, 맥 OS 등 기본 쉘로 채택 되어있다. 
    - C Shell 과 Bourne Shell 의 기능들이 많이 포함 되어 있다. 
    - 설치 위치는 '/bin/bash' 이다.
### 3. 응용프로그램
+ 개발보구, 문서 편집도구, 네트워크 관련 도구 등
### 4. 가상환경
컴퓨터를 2대이상 사용하지 않고 한대의 컴퓨터로 리눅스를 실습하기 위한 방법으로
VM을 이용해서 가상환경을 세팅하여 리눅스를 설치하고 실행한다.
#### - Virtual Box 설치
##### Virtual Box 다운로드 링크 - https://www.virtualbox.org/wiki/Downloads

1. Virtual Box 설치
<img width="1408" alt="1 a 버츄얼박스" src="https://user-images.githubusercontent.com/79190824/148652340-57619f1e-eada-4b77-8414-b39dc7e360db.png">

- 사이트 접속해서 사용중인 운영체제에 맞게 설치

2. 우분투 설치
##### 우분투 설치 링크 - https://ubuntu.com/download/desktop
- 우분투 홈페이지에서 다운로드


3. Virtual Box 실행

<img width="839" alt="스크린샷 2022-01-07 오후 2 40 49" src="https://user-images.githubusercontent.com/79190824/148652577-438a19b8-a46c-4666-9baf-f9c3cdf755bd.png">

4. 가상 환경에 우분투 설치
<img width="944" alt="스크린샷 2022-01-07 오후 2 44 46" src="https://user-images.githubusercontent.com/79190824/148652582-5d0ccebb-a127-426b-96e2-41eaf0c6e9d0.png">

- 설정 -> 저장소 -> 디스크 아이콘을 누르고 디스크 파일 선택을 눌러 다운 받은 우분투를 선택



## 참고
https://hongci.tistory.com/5


https://12bme.tistory.com/220


https://tlfod-server-security.tistory.com/2
