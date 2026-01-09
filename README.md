# Layout Optimization Demo

Ứng dụng Android demo để so sánh các kỹ thuật tối ưu hóa layout XML.

## Cấu trúc Project

```
com.example.optimize_layout_xml/
├── MainActivity.java                    # Màn hình chính
└── optimizations/                       # Package chứa các loại tối ưu hóa
    └── hierarchy/                       # Tối ưu hóa độ sâu hierarchy
        ├── HierarchySelectorActivity.java
        ├── UnoptimizedActivity.java     # LinearLayout lồng nhau (5 cấp)
        └── OptimizedActivity.java       # ConstraintLayout flat (1 cấp)
```

## Tính năng hiện tại

### 1. Tối ưu hóa độ sâu Hierarchy

So sánh hiệu suất giữa:

- **Chưa tối ưu**: LinearLayout lồng nhau 5 cấp

  - Layout file: `activity_hierarchy_unoptimized.xml`
  - Hierarchy depth: 5 levels
  - Nhiều view groups lồng nhau gây chậm quá trình measure/layout

- **Tối ưu**: ConstraintLayout flat
  - Layout file: `activity_hierarchy_optimized.xml`
  - Hierarchy depth: 1 level (flat)
  - Tất cả views là direct children của ConstraintLayout
  - Hiệu suất tốt hơn đáng kể

## Cách sử dụng

1. Mở ứng dụng
2. Nhấn nút **"Tối ưu hóa độ sâu"**
3. Chọn **"Chưa tối ưu"** hoặc **"Tối ưu"** để xem sự khác biệt
4. Sử dụng Android Studio Layout Inspector để xem chi tiết hierarchy

## Mở rộng trong tương lai

Cấu trúc folder đã được thiết kế để dễ dàng thêm các loại tối ưu hóa khác:

```
optimizations/
├── hierarchy/        # ✅ Đã hoàn thành
├── viewstub/         # 🔜 ViewStub lazy loading
├── merge/            # 🔜 Merge tag optimization
├── recyclerview/     # 🔜 RecyclerView vs ListView
└── databinding/      # 🔜 Data Binding vs findViewById
``
```
