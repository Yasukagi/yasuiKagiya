# yasuiKagiya
## Abstract
kinguinやG2Aなどの鍵屋の情報を収集し、適切な形で提供してくれるwebサービスを作成するプロジェクト。
webサービスのモデルはMVCモデルを利用したものとする。

## プロジェクト構成
- サーバサイド：Java
- クライアントサイド：JSP
- Webサーバ：Tomcat
- テスト：JUnit
- ビルドツール：なんでも

### Gradle
インストール方法→gradlewを実行するだけ (windowsならgradlew.bat
- gradle/wrapper  
Gradleをインストールしてくれるヤツ．使う為にはgradlewかgradlew.batを走らせる
- gradlew  
Mac/Unix用のスクリプト．実行すると勝手にGradleをインスコする
- gradlew.bat  
Windows用のスクリプト．上に同じ  

## ディレクトリ構成
```
yasuiKagiya/
|-- src
|   |-- java ****//javaのソースはここに置く
|   |-- jsp ****//jspのソースはここに置く（webapp以下では管理しない）
|   |-- resources ****//データベースとかのリソース
|   |-- webapp ****//Tomcatへデプロイするためのディレクトリ
|
|-- test
    |-- java ****//テスト用
    |-- resources ****//テスト用
```