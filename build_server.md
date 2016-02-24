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

1. Javaのインストール`$ yum install java-1.8.0-openjdk.x86_64`
2. `$ export JAVA_HOME=/usr/lib/jvm/jre-1.8.0-openjdk.x86_64`
3. a
  1. a


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

