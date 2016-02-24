# サーバ構築
サーバを構築する手順の備忘録と共有

|IPアドレス|160.16.118.1|
|:---|:---|
|ドメイン名|yasukagi.com|
|DNS|ns1.dns.ne.jp|
|whois情報|http://whois.ansi.co.jp/yasukagi.com|

## Webサーバ(Apache/Tomcat)
### 必要なもの
- Apache HTTP Server

Webサーバ (HTTPリクエストに応答する)
- Apache Tomcat

サーブレットコンテナ (Javaを動かす)
- JDK

Java本体

### 構築手順
Javaをインスト→Tomcatインスト→httpd(Apache HTTP Server)インスト→tomcatのデフォルトポート無効化→apacheをtomcatに接続

```
$ su - root
# yum install java-1.8.0-openjdk.x86_64  //Javaインスト
# export JAVA_HOME=/usr/lib/jvm/jre-1.8.0-openjdk.x86_64  //環境変数にJAVA_HOMEを設定
# wget http://ftp.yz.yamagata-u.ac.jp/pub/network/apache/tomcat/tomcat-9/v9.0.0.M3/bin/apache-tomcat-9.0.0.M3.tar.gz  // tomcatのダウンロード(yumには最新のパッケージがない)
# tar xvzf apache-tomcat-9.0.0.M3.tar.gz
# mv tomcat /usr/local/  //tomcatのインストール
# export CATALINA_HOME=/usr/local/tomcat
#

```

## メールサーバ(Postfix/Dovecot)

## SSHサーバ

## サーバ管理
### プロセス実行状態
```
ps uax
```
### プロセスの実行ユーザ指定
```
sudo -u tomcat /usr/local/tomcat/bin/startup.sh
```

