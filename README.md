# ECM

![JDK: v9.0.4 (shields.io)](https://img.shields.io/badge/JDK-v9.0.4-green) ![JavaFX: v1.0 (shields.io)](https://img.shields.io/badge/JavaFX-v1.0-green) ![exe4j: v6.0.1 (shields.io)](https://img.shields.io/badge/exe4j-v6.0.1-yellow) ![license: MIT (shields.io)](https://img.shields.io/badge/license-MIT-blue)

电子元件管理平台（Electronic component management），用户可自由添加、删除、修改、查找元件库。

<br>

## Background

对于硬件爱好者来说，元器件的管理可能是最让人头痛的事情之一了，如何简单快捷地存储、查找元器件就成了我们急切想要解决的问题。因此，笔者利用`JavaFX`和`xml`文件设计了一款简约的元器件管理程序，可视化地帮助用户存储、查找元器件。

<br>

## Environment

- [IDEA]([IntelliJ IDEA: The Capable & Ergonomic Java IDE by JetBrains](https://www.jetbrains.com/idea/))（非必需）

<br>

## Usage

1. 下载`Install`文件夹

   ![image-20220102161921420](https://s2.loli.net/2022/01/02/8gWKJvNYP1ljVwy.png)

   <br>

2. 双击`ECM.exe`即可打开应用，无需安装！

   ![image-20220102162034768](https://s2.loli.net/2022/01/02/jIkny2XYWoJtzOE.png)

   <br>

3. 在设置中可更改元器件存储位置

   ![image-20220102162212846](https://s2.loli.net/2022/01/02/CplfwBdmSs6kLZI.png)

   ![image-20220102162234342](https://s2.loli.net/2022/01/02/NiSK4Xk5VFwuZRO.png)

   <br>

4. 点击`添加`元器件

   ![image-20220102162314255](https://s2.loli.net/2022/01/02/vZYSbQ3lP56utfN.png)

   <br>

5. 选择`类别`并填写相应信息，点击保存即可存储元器件（目前不支持用户自定义类别）

   ![image-20220102162416594](https://s2.loli.net/2022/01/02/ilCnxRr6FgkT8QX.png)

   ![image-20220102162648453](https://s2.loli.net/2022/01/02/NvZoymVI3f7D592.png)

   <br>

6. 点击`查找`元器件，查找时必须先选择`类别`

   ![image-20220102162729978](https://s2.loli.net/2022/01/02/t1QWLvlIbPo7SEJ.png)

   ![image-20220102162812543](https://s2.loli.net/2022/01/02/xHEDAfU5w1Zsehd.png)

   ![image-20220102162827964](https://s2.loli.net/2022/01/02/ouD5WHrOtMqwmyh.png)

   <br>

## 元件命名格式

用户在创建`电阻`、`电容`、`电感`时，可能会出现`类型格式有误`的提示，这是因为程序对这三种元器件的`型号`命名做了限制

- 电阻
  1. `0 ~ 999.9Ω `：阻值_整数部分 + R + 阻值小数部分（例如：50R1表示50.1Ω）
  1. `1k ~ 999.9kΩ`：阻值_整数部分 + K + 阻值小数部分（例如：99K9表示99.9kΩ）
  1. `1M ~ ∞`：阻值_整数部分 + M + 阻值小数部分（例如：10M5表示10.5MΩ）
  
- 电容

  仅允许以`n`、`u`、`f`结尾

- 电感

  仅允许以`n`、`u`结尾

  <br>

## License

MIT © Richard McRichface


​     
​      