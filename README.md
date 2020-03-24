# Bilibili ChatStat 弹幕统计工具
该项目是用swing开发的GUI程序，支持各项弹幕统计、单个或批量视频弹幕爬取、直播间弹幕爬取，详见下文。  
**开发者：Jelly Black**  
哔哩哔哩 (゜-゜)つロ 干杯~  
哔哩哔哩同名，[点此访问我的哔哩哔哩主页](https://space.bilibili.com/368205203)  

---
### ChatStat 1.3.0 更新日志  
1. 【重要更新】直播弹幕抓取支持多线程。
2. 为适应多线程爬虫的需要，重复弹幕验证范围由原来的10个上升到2048个，并且爬虫线程和实时弹幕处理线程分开。这可以大大减小零缓冲误判的几率（尤其是弹幕特别密集且延迟波动较大时），但CPU占用率可能会升高。
### ChatStat 1.4.0 更新日志  
1. 视频弹幕爬取同时支持AV号和BV号。（刚更完1.3.0，就马上收到更新BV号的通知，一天两更不容易啊）
### ChatStat 1.4.1-alpha （最新版） 修订日志
1. 尝试修复弹幕处理线程提前结束的bug。
---

# 致哔哩哔哩热爱者
哔哩哔哩小黑屋看守员提醒您：  
视频千万条，  
版权第一条。  
爬虫不规范，  
游客两行泪。  
  
**本项目仅用于统计分析**（例如你可以统计阿伟在某个UP主下死了多少次）**，不可用于非法用途。**  
**开发者不能确定滥用爬虫是否会导致 你 号 没 了 ，所以进行爬取时您可以在网页端退出哔哩哔哩账号，为了保险可以清浏览器缓存，甚至还可以使用IP代理。**（如果你不做大量爬取，或者你是 封 号 斗 罗 ，请忽略）  
在看源码前，建议吃点降压药，因为我的代码写得像奥利给一样233  

---
# 安装操作
**【通用】请下载适用于您的操作系统的JRE，安装并配置好JRE后，在“releases”里下载jar文件运行。**  
事实上打包成exe也需要JRE库，因此不提供exe的下载（况且JRE的大小为数百MB，你知道Github下载的速度），见谅。

# 功能说明
## 导入xml文件
点击`添加xml文件`， 即可打开文件选择器。您可以选择一个或多个**xml**文件。如果您选择的文件中包含非xml文件，此次导入将无效。  
您可以从文件资源管理器中拖拽所需的xml文件到列表。  
添加文件后，在列表中会显示文件的路径。如需移除，请在列表中选择一个或多个文件，然后点击`删除选中的xml文件`。  
添加xml文件后，您便可以使用统计功能，详见后文。  
## 视频弹幕爬取
视频弹幕爬取提供三种选项：爬取单视频、爬取多视频、爬取UP主的全部视频。  
### 爬取单视频
请在对应的文本框中键入视频的av号或bv号。**有无“av”或“bv”前缀无影响**，然后点击`选定`。  
不知道怎么看av号/bv号？？  
进入视频详情页，在浏览器地址栏中有如下所示的URL：  

    https://www.bilibili.com/video/av170001

或

    https://www.bilibili.com/video/BV17x411w7KC

av/bv后面的数字便是av号/bv号（示例是辣♂个♂男♂人的视频）。  
### 爬取多视频
请准备好txt文件，格式要求每一行为一个av号或bv号（是否有“av”或“bv”前缀无影响），不能有其他内容，如下：  

    av170001  
    Av170002  
    aV170003  
	Bv17x411w7KC
    170004  
    170005  
	17x411w7KD  

然后点击`选择txt`，选择上述txt文件，之后点击`选定`。  
### 爬取UP主的所有视频
请在对应的文本框中键入UP主的UID（无“uid”前缀），然后点击`选定`。  
不知道怎么看UID？  
进入UP主的主页，看浏览器URL：  

    https://space.bilibili.com/368205203

368205203便是UP主的UID（示例是我的UID）。  
### 之后的操作
上述三种方式选定其中一种后，点击`确定配置，下一步`。如果您选择的是“爬取UP主的所有视频”，会弹出对话框用于确认UP主信息。  
之后选择输出目录。如果你爬取的是单视频并且该视频只有一个分P，那么你需要选择输出的文件；如果你爬取的单视频有多个分P、爬取多视频或者爬取UP的所有视频，那么你需要选择输出目录。  
最后弹出*温馨提示*，即哔哩哔哩小黑屋看守员的标语，你需要再次确认。  
爬虫正式开始运行后，在日志区可以看到输出日志。点击`清空日志`可清楚日志区的日志，长按`清空日志`可强制刷新日志区（不清空日志）。  
**为减少可能的封号风险，我将爬取间隔控制在了数秒。实际上如果用多线程不间断爬取，在几秒之内就可以爬取完UP主的全部弹幕。**
## 直播弹幕抓取
首先您需要填写直播间房间号。  
不知道怎么看房间号？  
进入哔哩哔哩直播间，看浏览器URL：  

    https://live.bilibili.com/2233

2233便是直播间房间号(示例是哔哩哔哩官方的御用直播间)。  
然后选择爬取间隔。间隔的选取和弹幕密度有关。如果弹幕密集，调为200ms~800ms都是可以的；如果弹幕稀疏，调为1000ms以上都行。建议开启`智能调整爬取间隔`，以根据弹幕密度自动调整。  
我采用的是  

    https://api.live.bilibili.com/ajax/msg

的API，服务器会返回最新的10条弹幕，如果爬取间隔过大，则可能漏掉一些弹幕（此时显示缓冲区为0）。理论上间隔越小，越不容易错过弹幕。*如果你爬取的是拜年祭的直播间，就是1.3亿人在线观看，每秒刷几百条弹幕的那种，服务器也无能为力啊，毕竟2020拜年祭直播刚开始时，弹幕服务器的延迟都上天了QwQ*  
如果你不担心 你 号 没 了 ，可以把间隔设置为0，并取消`智能调整爬取间隔`，以保证不错过弹幕。（*注意我的前提*）  
**手动调整爬取间隔后，一定要点击`注册`，否则不会生效。**  
之后`选择输出目录`，最后点击`开始爬取`，左侧便可看到实时弹幕及爬取日志。点击`清空日志`可清楚日志区的日志，长按`清空日志`可强制刷新日志区（不清空日志）。 
长按`注册`可以让爬取间隔临时调为0，并且取消智能调整爬取间隔，以确保弹幕高能区顺利度过。  
未开始爬取时，如果您勾选下方`当主播开播时自动启动爬虫`，那么程序会持续向服务器请求直播间状态，一旦开播将立即启动爬虫。  
已开始爬取时，如果您勾选下方`当主播关播时自动停止爬虫`，那么程序会持续向服务器请求直播间状态，一旦关播将立即停止爬虫。  
您可以勾选`防手胡（锁定控件）`，以避免意外点到结束按钮。  
如果您要结束爬取，可选择下面`结束并输出为json`、`结束并模拟输出xml`的选项。前者将输出到json文件，后者将模拟哔哩哔哩视频弹幕的格式，输出xml文件，可用于该程序统计。  
### 使用多线程
勾选`使用多线程`复选框，然后会进行延迟测试。测试结束后，`开始爬取`按钮显示为可用，此时已进入多线程模式。进入多线程模式后，您不可以更改直播间房间号，除非退出多线程模式。  
为保护您的账号安全，多线程模式下爬取间隔不允许小于50ms。如果访问过于频繁，服务器会封禁你的ip：  
```
错误号: 412  
由于触发哔哩哔哩安全风控策略，该次访问请求被拒绝。  
The request was rejected because of the bilibili security control policy.  
```
万一被禁ip，请重启一下路由器以更换外网ip。  
如果你立志要做封  号  斗  罗，请把源码clone到本地，然后进入`src/script/Config.java`，找到以下字段：  

    public static boolean I_DO_NOT_FEAR_BANNING = false;

把`false`改为`true`，编译运行，即可强制将间隔设置到50ms以下。（UI内不提供操作以上字段的方法）  

**直播弹幕抓取输出的xml文件仅可用于该程序统计，并且不要勾选`CRC32反算`，详见下文。**  
# 弹幕统计功能
以下是弹幕统计通用的选项。  

 - **忽略大小写**  
 进行相同弹幕检查时，会忽略大小写差异。  
 - **转换为全角字符**  
 将半角字符转换为全角字符。  
 - **删除首尾空格**  
 删除每条弹幕首尾的空格。  
 - **尝试拆分弹幕**  
 将弹幕重复的文字拆分，使重复统计更加精确，比如以下两条弹幕：  

    awsl  
    awsl awsl awsl awsl awsl awsl awsl

 它们经拆分后都变为“awsl”，如果勾选了此选项，两条弹幕会被认为是“相同弹幕”。  
 
 - **高级弹幕匹配开关**  
 利用正则表达式合并弹幕。这可以精确地合并弹幕。如果您要统计阿伟的死亡次数，您可以定制弹幕合并规则库（详见“更多”），将阿伟死亡的各种表达方式合并为“awsl”，利用弹幕重复统计即可得出。合并规则示例：  
  
  正则表达式                      | 原弹幕示例        | 处理后的弹幕
  :-----:                         | :-----:           | :-----:  
  ^OH{2,}\$                       | OHHHHHHHHHHHHHH   | OHHHH 
  .\*[Aa].\*[Ww].\*[Ss].\*[Ll].\* | AAAAWWWWSSSSLLLL  | awsl
  ^23{2,}\$                       | 23333333333333333 | 23333

  **注意：正则表达式中存在一些特殊字符，如果要匹配这些字符本身，必须在前面加转义字符“\”。如果您不了解，建议百度正则表达式教程。**  
  1.2.0添加了<@ignore>和<@only>标签。<@ignore>用于忽略匹配对应正则表达式的弹幕。例如：  
  
  正则表达式                      | 替换字符串  
  :-----:                         | :-----:  
  前方高能预警，注意这不是演习    | <@ignore>  
  可爱即正义~~                    | <@ignore>  
  糟了，是心动的感觉！            | <@ignore>  
  这个直播间已经被我们承包了！    | <@ignore>  
  [干乾]杯                        | <@ignore>  

  这样在统计弹幕时就会忽略所有匹配<@ignore>对应的正则表达式的弹幕。  
  <@only>标签用于只统计匹配对应正则表达式的弹幕。例如：  
    
  正则表达式                      | 替换字符串  
  :-----:                         | :-----:  
  awsl                            | <@only>  
  23333                           | <@only>  

  这样在统计弹幕时就会只统计所有匹配<@only>对应的正则表达式的弹幕。  
  标签弹幕的处理位于弹幕正则替换之后，不论标签位于csv文件中的哪一行。这意味着你可以先把需要“ignore”或“only”的弹幕用正则替换为同一弹幕，然后对统一替换后的弹幕添加标签。  
  **注意**：两个标签不推荐在同一次统计中使用；如果真的同时使用，则<@only>标签会覆盖<@ignore>标签。  
  **您必须开启`高级弹幕匹配开关`才能使用标签功能。**  
  如需更换标签，您需要在更改ChatStat.csv后重新启动ChatStat以应用更改。
  
 - **一个人发的多条相同弹幕只计一次**  
 这可以排除刷屏对统计结果的干扰。该选项的判定位于前面的选项处理完之后，也就意味着，如果您开启了“尝试拆分弹幕”，那么以下*同一用户*发送的两条弹幕  

    哈哈哈哈哈哈  
    哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈

  将会被认为是相同弹幕，并在弹幕库中去掉后一条弹幕。  
 - **输出方式**
  支持swing表格控件展示和导出为csv表格（推荐后者），如果您安装了电子表格软件（如Office Excel，WPS表格等），那么您应该能打开csv文件。如果您要查看曲线图，那么您需要使用“导出为csv文件”，然后用电子表格软件绘制图像。导出完毕后，程序会为您自动打开csv文件。  
   
以下是针对各项功能的说明。  
## 重复弹幕统计
重复弹幕统计可用于查看观众发送最多的弹幕是什么。程序首先找出各弹幕的重复次数，然后按重复次数由多到少排名。*输出的排名结果示例见该项目的“others”分支。*  
参与排名的最大数量指在输出结果中展示前多少名。设置为-1即全部展示。  
## 弹幕频数曲线统计
该功能可查看弹幕的密集程度随时间变化的情况，类似于哔哩哔哩H5播放器的“高能进度条”。  
程序将按照您设置的开始时间、结束时间、采样长度对弹幕按时间进行分组，采样长度即每组的时间长度。如果您想一直统计到视频末尾，请将终止时间设置为-1。  
采样长度不是越大越好，也不是越小越好。如果您统计的是4分钟左右的歌曲pv视频，并且弹幕非常活跃，可以将采样长度设置为15s；如果您统计的是1小时以上的电影或番剧，则采样长度可以设置为60s、90s、120s等。具体设置为多少得参考弹幕密度，您可以多次调整已获得理想的统计曲线。  
## 弹幕刷屏统计
您可以用该功能统计刷屏最多的用户。“参与排名的最大弹幕数量”含义和重复弹幕统计相同。  
哔哩哔哩为保护弹幕发送者的隐私，记录弹幕发送者时使用的是UID的CRC32值。`CRC32反算`将根据用户的CRC32值反算出用户的UID。*CRC32反算的算法很辣鸡，程序暴力破解，需要很多时间，不建议开启。*  
**如果您统计的弹幕文件中包含由本项目“直播弹幕抓取”输出的模拟xml文件，则不要开启`CRC32反算`。因为直播弹幕直接包含用户的UID信息，导出时在“CRC32”的位置输出的是UID，进行CRC32反算会导致进程阻塞。**  
## 月（日）弹幕数量曲线统计
弹幕数量曲线统计可以查看弹幕数量随月份或日期变化的情况。由于哔哩哔哩视频的弹幕池总数是固定的，新弹幕会将旧弹幕挤下去，因此可能几年前发布的视频（如av170001）的弹幕却集中在最近几个星期。  
该统计也可以间接反映视频或弹幕的活跃程度，因为弹幕的时间跨度越小，近期发送的弹幕就越多。  
## 日均弹幕活跃时段统计
该功能可以查看用户在一天内的哪个时段发送弹幕最多。*你可以统计观看视频的夜猫子数量占比。*  
功能选项和“弹幕频数曲线统计”类似。  
**点击面板右下角的按钮以开始统计。**
# 更多
## 高级弹幕合并规则库
如果您是第一次运行ChatStat，则程序会在同目录下生成`ChatStat.csv`，里面是默认的合并规则库。以后运行时，程序会导入同目录下的规则库（**文件名必须是“ChatStat.csv”，不区分大小写**）。如果未找到，则会创建新的规则库；如果导入失败，程序会**覆写规则库**。  
合并规则库的语法：  
每一列为一个合并规则，每列的第一行为正则表达式，第二行为替换字符串。第二行以后您可以添加注释，程序不会导入。您可以参考默认的规则库。  
您可以在`查看高级弹幕合并规则`选项卡查看载入的规则库。
*在“others”分支中有一些拓展合并规则库，您可以下载使用。使用方法：将需要添加的合并规则库追加到“ChatStat.csv”文件中，然后重启ChatStat。*  
## 示例统计结果
在“others”分支中有一些示例结果，用于您快速了解项目的统计效果。  

---
**联系开发者：**  
QQ：1574854804  
Email：l45531@126.com  
哔哩哔哩 / Github：JellyBlack
