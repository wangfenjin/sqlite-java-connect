# SQLLite3 with simple extension

This is a minimal repo project that connects to a sqlite3 database and load [simple extensions](https://github.com/wangfenjin/simple).

In addition, for simplicity, rather that use a depency manager (i.e Maven etc), `sqlite-jdbc-3.23.1.jar` is checked into the same repo.

Download the simple extension from [release page](https://github.com/wangfenjin/simple/releases), which we already checked into this repo.

To run (from the repo root directory)

```
./run.sh
```

You should get the following output

```
Connection to SQLite has been established.
jieba_query: "我" AND "是" AND "中国" AND "人民" AND "的" AND "儿子" AND "，" AND "我" AND "深情" AND "地爱" AND "着" AND "我" AND "的" AND "祖国" AND "和" AND "人民"
Found Henry Fonda
```
