# Lure Fishing Mod (路亚钓鱼模组) - MC 1.20.1 Forge 版

一套不依赖 MCreator 的手写 Forge 1.20.1 模组源码。

## 已实现玩法
- 路亚竿右键蓄力抛投（蓄力越久抛得越远，仿真实手感）
- 拟饵落水后缓慢下沉，6 格内的鲈鱼会被吸引追饵
- 鱼咬钩后掉落渔获（鲈鱼物品）
- 拟饵渲染使用你自己的 Blockbench 鱼竿模型（含鱼竿、轮座、导环）

## 构建方法
1. 安装 JDK 17（1.20.1 用 17，首次构建需要联网下载依赖）
2. 命令行进入工程目录：
   - Windows: `gradlew.bat build`
   - Mac/Linux: `./gradlew build`
   （没有 gradlew 时先装 Gradle 跑 `gradle wrapper`，
     或直接用 IntelliJ IDEA 打开工程目录）
3. 产物在 `build/libs/fishingmod-1.0.0.jar`

## 也可以用 GitHub Actions 零安装构建
把工程推到 GitHub 仓库，Actions 页等构建完成，
Artifacts 里下载 `fishing-mod-jar-1.20.1` 即可（无需本地装 JDK）。

## 与 1.21.1 版的差异（适配点）
- Forge 47.2.0 + ForgeGradle 6 + JDK 17（1.21.1 是 NeoForge 21.1 + JDK 21）
- RegistryObject / ForgeRegistries（1.21.1 是 DeferredHolder / Registries）
- `ResourceLocation` 用构造器（1.21.1 用 `fromNamespaceAndPath`）
- `defineSynchedData()` 无参版（1.21.1 是 Builder 版）
- FoodProperties 用 `saturationMod`（1.21.1 是 `saturationModifier`）
- getUseDuration 单参数（1.21.1 双参数）

## 下一步扩展
1. 收线：按住右键时 LureEntity 每 tick 向玩家移动
2. 张力系统：超限断线跑鱼
3. 动画：接 GeckoLib 驱动你那 16 个钓鱼动画
4. 自然生成：biome modifier 让鲈鱼在水域刷新
