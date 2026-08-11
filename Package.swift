// swift-tools-version: 6.0
import PackageDescription

let package = Package(
    name: "Orbit",
    platforms: [
        .iOS(.v15)
    ],
    products: [
        // Event definitions only (e.g. TabClicked, WorldIdTab).
        .library(name: "OrbitCatalog", targets: ["OrbitCatalog"]),
    ],
    targets: [
        .binaryTarget(
            name: "OrbitCatalog",
            // url/checksum are rewritten by the Publish workflow on every release.
            url: "https://github.com/jaidensiu/orbit/releases/download/v0.0.11/OrbitCatalog-0.0.11.xcframework.zip",
            checksum: "6bb65231f3d8f9917ad58d71143510b904949f18f544c6c2f88fd97b8c79516a"
        ),
    ]
)
