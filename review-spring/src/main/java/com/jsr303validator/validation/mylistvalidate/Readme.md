Fer - MyList story - Validate

### 背景

#### Section1: Error response
Mylist的校验分为两种，一种是字段的校验，另一种是全局的错误。
错误的Response只有两种情况，也就是FIELD_ERROR和PAGE_ERROR。
1. FIELD_ERROR response
    ```json
   {
      "success": false,
      "errors": {
          "type": "FIELD_ERROR",
          "message": "..."
      }
   }
   ```
2. PAGE_ERROR response
    ```json
   {
      "success": false,
      "errors": {
        "type": "PAGE_ERROR",
        "message": "..."
      }
   }
    ```
> 如果出现错误，后端理应返回错误的response但没有返回,前端均视为PAGE_ERROR?

#### Section2: Success Response




