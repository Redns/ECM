# ECM

#### 介绍
电子元件管理平台（Electronic component management）

#### 软件架构
基于 `JavaFX` 开发，JDK版本 `9.0.4`


#### 安装教程

下载 `Install` 文件夹，双击文件夹内 `ECM.exe` 文件


#### 使用说明

请参见 Install 文件夹内 `Readme.pdf`文件


#### 参与贡献


#### 基本特性
1. 添加、查找元器件
2. 无需`Java`环境

#### 文件索引
├─Code
│  │  .DS_Store
│  │  .keep
│  │  JavaFxApplication.iml
│  │  location.cfg
│  │
│  ├─.idea
│  │  │  compiler.xml
│  │  │  description.html
│  │  │  encodings.xml
│  │  │  gradle.xml
│  │  │  misc.xml
│  │  │  modules.xml
│  │  │  project-template.xml
│  │  │  uiDesigner.xml
│  │  │  vcs.xml
│  │  │  workspace.xml
│  │  │
│  │  └─artifacts
│  │          JavaFxApplication_jar.xml
│  │
│  ├─out
│  │  ├─artifacts
│  │  │  └─JavaFxApplication_jar
│  │  │          JavaFxApplication.jar
│  │  │
│  │  └─production
│  │      └─JavaFxApplication
│  │          ├─Data
│  │          │  └─Data
│  │          │      ├─C
│  │          │      │      1n_0603.xml
│  │          │      │      1u_0603.xml
│  │          │      │      Data.xml
│  │          │      │
│  │          │      ├─Diode
│  │          │      │      1_0402.xml
│  │          │      │      IN4007_SMA.xml
│  │          │      │
│  │          │      ├─IC
│  │          │      │      OPA171_0402.xml
│  │          │      │
│  │          │      ├─R
│  │          │      │      100R_0603.xml
│  │          │      │      14R_0402.xml
│  │          │      │      1R_0402.xml
│  │          │      │      999R_0603.xml
│  │          │      │
│  │          │      └─Relay
│  │          │              B3GA4.5Z_DIP.xml
│  │          │
│  │          ├─icon
│  │          │      About.png
│  │          │      add.png
│  │          │      ECM.png
│  │          │      search.png
│  │          │      set.png
│  │          │
│  │          ├─META-INF
│  │          │      MANIFEST.MF
│  │          │
│  │          └─sample
│  │                  About.fxml
│  │                  Add.fxml
│  │                  Component.class
│  │                  Controller_Add.class
│  │                  Controller_menu.class
│  │                  Controller_Search.class
│  │                  location.txt
│  │                  Main.class
│  │                  menu.fxml
│  │                  SAXParseXML.class
│  │                  Search.fxml
│  │                  Search_Files.class
│  │                  Set.class
│  │                  Set.fxml
│  │
│  └─src
│      ├─Data
│      │  └─Data
│      │      ├─BJT
│      │      ├─C
│      │      │      1n_0603.xml
│      │      │      1u_0603.xml
│      │      │      Data.xml
│      │      │
│      │      ├─Connector
│      │      ├─Crystal
│      │      ├─Diode
│      │      │      1_0402.xml
│      │      │      IN4007_SMA.xml
│      │      │
│      │      ├─Electroacoustic
│      │      ├─IC
│      │      │      OPA171_0402.xml
│      │      │
│      │      ├─L
│      │      ├─Lighter
│      │      ├─Other
│      │      ├─Protection
│      │      ├─R
│      │      │      100R_0603.xml
│      │      │      14R_0402.xml
│      │      │      1R_0402.xml
│      │      │      999R_0603.xml
│      │      │
│      │      ├─Relay
│      │      │      B3GA4.5Z_DIP.xml
│      │      │
│      │      ├─Sensor
│      │      ├─Switch
│      │      └─Transformer
│      ├─icon
│      │      About.png
│      │      add.png
│      │      ECM.png
│      │      search.png
│      │      set.png
│      │
│      ├─META-INF
│      │      MANIFEST.MF
│      │
│      └─sample
│              About.fxml
│              Add.fxml
│              Component.java
│              Controller_Add.java
│              Controller_menu.java
│              Controller_Search.java
│              location.txt
│              Main.java
│              menu.fxml
│              SAXParseXML.java
│              Search.fxml
│              Search_Files.java
│              Set.fxml
│              Set.java
│
├─Install
│  │  .keep
│  │  ECM.exe
│  │  location.cfg
│  │
│  ├─Data
│  │  ├─BJT
│  │  ├─C
│  │  ├─Connector
│  │  ├─Crystal
│  │  ├─Diode
│  │  ├─Electroacoustic
│  │  ├─IC
│  │  ├─L
│  │  ├─Lighter
│  │  ├─Other
│  │  ├─Protection
│  │  ├─R
│  │  ├─Relay
│  │  ├─Sensor
│  │  ├─Switch
│  │  └─Transformer
│  └─JRE
│      ├─bin
│      │  │  api-ms-win-core-console-l1-1-0.dll
│      │  │  api-ms-win-core-datetime-l1-1-0.dll
│      │  │  api-ms-win-core-debug-l1-1-0.dll
│      │  │  api-ms-win-core-errorhandling-l1-1-0.dll
│      │  │  api-ms-win-core-file-l1-1-0.dll
│      │  │  api-ms-win-core-file-l1-2-0.dll
│      │  │  api-ms-win-core-file-l2-1-0.dll
│      │  │  api-ms-win-core-handle-l1-1-0.dll
│      │  │  api-ms-win-core-heap-l1-1-0.dll
│      │  │  api-ms-win-core-interlocked-l1-1-0.dll
│      │  │  api-ms-win-core-libraryloader-l1-1-0.dll
│      │  │  api-ms-win-core-localization-l1-2-0.dll
│      │  │  api-ms-win-core-memory-l1-1-0.dll
│      │  │  api-ms-win-core-namedpipe-l1-1-0.dll
│      │  │  api-ms-win-core-processenvironment-l1-1-0.dll
│      │  │  api-ms-win-core-processthreads-l1-1-0.dll
│      │  │  api-ms-win-core-processthreads-l1-1-1.dll
│      │  │  api-ms-win-core-profile-l1-1-0.dll
│      │  │  api-ms-win-core-rtlsupport-l1-1-0.dll
│      │  │  api-ms-win-core-string-l1-1-0.dll
│      │  │  api-ms-win-core-synch-l1-1-0.dll
│      │  │  api-ms-win-core-synch-l1-2-0.dll
│      │  │  api-ms-win-core-sysinfo-l1-1-0.dll
│      │  │  api-ms-win-core-timezone-l1-1-0.dll
│      │  │  api-ms-win-core-util-l1-1-0.dll
│      │  │  api-ms-win-crt-conio-l1-1-0.dll
│      │  │  api-ms-win-crt-convert-l1-1-0.dll
│      │  │  api-ms-win-crt-environment-l1-1-0.dll
│      │  │  api-ms-win-crt-filesystem-l1-1-0.dll
│      │  │  api-ms-win-crt-heap-l1-1-0.dll
│      │  │  api-ms-win-crt-locale-l1-1-0.dll
│      │  │  api-ms-win-crt-math-l1-1-0.dll
│      │  │  api-ms-win-crt-multibyte-l1-1-0.dll
│      │  │  api-ms-win-crt-private-l1-1-0.dll
│      │  │  api-ms-win-crt-process-l1-1-0.dll
│      │  │  api-ms-win-crt-runtime-l1-1-0.dll
│      │  │  api-ms-win-crt-stdio-l1-1-0.dll
│      │  │  api-ms-win-crt-string-l1-1-0.dll
│      │  │  api-ms-win-crt-time-l1-1-0.dll
│      │  │  api-ms-win-crt-utility-l1-1-0.dll
│      │  │  appletviewer.exe
│      │  │  awt.dll
│      │  │  concrt140.dll
│      │  │  dcpr.dll
│      │  │  decora_sse.dll
│      │  │  fontmanager.dll
│      │  │  glass.dll
│      │  │  java.dll
│      │  │  java.exe
│      │  │  javafx_font.dll
│      │  │  javafx_font_t2k.dll
│      │  │  javafx_iio.dll
│      │  │  javajpeg.dll
│      │  │  javaw.exe
│      │  │  jawt.dll
│      │  │  jimage.dll
│      │  │  jli.dll
│      │  │  jrunscript.exe
│      │  │  jsound.dll
│      │  │  jsoundds.dll
│      │  │  kcms.dll
│      │  │  keytool.exe
│      │  │  lcms.dll
│      │  │  mlib_image.dll
│      │  │  msvcp120.dll
│      │  │  msvcp140.dll
│      │  │  msvcr120.dll
│      │  │  net.dll
│      │  │  nio.dll
│      │  │  prefs.dll
│      │  │  prism_common.dll
│      │  │  prism_d3d.dll
│      │  │  prism_sw.dll
│      │  │  splashscreen.dll
│      │  │  t2k.dll
│      │  │  ucrtbase.dll
│      │  │  vcruntime140.dll
│      │  │  verify.dll
│      │  │  zip.dll
│      │  │
│      │  └─server
│      │          jvm.dll
│      │
│      └─lib
│          │  classlist
│          │  fontconfig.bfc
│          │  fontconfig.properties.src
│          │  javafx-swt.jar
│          │  javafx.properties
│          │  jawt.lib
│          │  jrt-fs.jar
│          │  jvm.cfg
│          │  jvm.lib
│          │  modules
│          │  psfont.properties.ja
│          │  psfontj2d.properties
│          │  tzdb.dat
│          │  tzmappings
│          │
│          └─server
│                  Xusage.txt
│
└─Pkg
        .keep
        ECM.ico
        JavaFxApplication.jar
        pkg.exe4j
        电子.png
