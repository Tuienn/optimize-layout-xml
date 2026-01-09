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

### 2. Tái sử dụng Layout với Include/Merge

So sánh sự khác biệt khi tái sử dụng layout:

- **Không dùng Merge**: Include layout với root LinearLayout

  - Layout file: `reuse_layout_without_merge.xml`
  - Mỗi lần include tạo thêm 1 wrapper LinearLayout không cần thiết
  - Hierarchy depth: 2 levels
  - 3 wrapper views bị lãng phí

- **Dùng Merge**: Include layout với root `<merge>`
  - Layout file: `reuse_layout_with_merge.xml`
  - Views được gắn trực tiếp vào parent container
  - Hierarchy depth: 1 level (flat)
  - Loại bỏ hoàn toàn wrapper views
  - Hiệu suất tốt hơn, tiết kiệm bộ nhớ

### 3. Kiểm soát Overdraw (Loại bỏ Background thừa)

So sánh hiệu suất rendering với overdraw:

- **Có Overdraw**: Nhiều layer có background trùng lặp

  - Layout file: `activity_overdraw_with.xml`
  - Mọi layer đều có background màu trắng
  - Overdraw level: 2-3x (pixel bị vẽ nhiều lần)
  - Lãng phí tài nguyên GPU

- **Không Overdraw**: Loại bỏ background thừa với `@null`
  - Layout file: `activity_overdraw_without.xml`
  - Chỉ giữ lại background cần thiết
  - Container và label views dùng `android:background="@null"`
  - Overdraw level: 0-1x (tối ưu)
  - Hiệu suất rendering tốt hơn đáng kể

### 4. Tối ưu hóa danh sách với RecyclerView

So sánh hiệu suất với danh sách lớn:

- **Không tối ưu**: Tạo View thủ công cho mỗi item

  - Layout file: `activity_recyclerview_unoptimized.xml`
  - ScrollView + LinearLayout + addView() cho 100 items
  - Tất cả views được tạo và giữ trong bộ nhớ
  - findViewById() gọi lại cho mỗi item → chậm
  - Risk of OOM với danh sách dài

- **Tối ưu**: RecyclerView với ViewHolder pattern
  - Layout file: `activity_recyclerview_optimized.xml`
  - RecyclerView + PersonAdapter + ViewHolder
  - Chỉ tạo ~10 ViewHolders, tái sử dụng khi scroll
  - findViewById() chỉ gọi 1 lần cho mỗi ViewHolder
  - `setHasFixedSize(true)` → bỏ qua tính toán layout thừa
  - Smooth scrolling, memory efficient

## Cách sử dụng

1. Mở ứng dụng
2. Chọn loại tối ưu hóa muốn xem:
   - **"Tối ưu hóa độ sâu"**: So sánh LinearLayout lồng nhau vs ConstraintLayout
   - **"Tối ưu Include/Merge"**: So sánh include thông thường vs include với merge
   - **"Kiểm soát Overdraw"**: So sánh background trùng lặp vs loại bỏ background thừa
   - **"Tối ưu RecyclerView"**: So sánh tạo View thủ công vs RecyclerView + ViewHolder
3. Chọn **"Chưa tối ưu"** hoặc **"Tối ưu"** để xem sự khác biệt
4. Sử dụng các công cụ phân tích:
   - **Layout Inspector**: Xem chi tiết hierarchy
   - **Debug GPU Overdraw**: Settings → Developer Options → Debug GPU Overdraw → Show overdraw areas
   - **Profiler**: Theo dõi memory usage và scroll performance

## Mở rộng trong tương lai

Cấu trúc folder đã được thiết kế để dễ dàng thêm các loại tối ưu hóa khác:

```
optimizations/
├── hierarchy/        # ✅ Đã hoàn thành
├── merge/            # ✅ Đã hoàn thành
├── overdraw/         # ✅ Đã hoàn thành
├── recyclerview/     # ✅ Đã hoàn thành
├── viewstub/         # 🔜 ViewStub lazy loading
└── databinding/      # 🔜 Data Binding vs findViewById
```
