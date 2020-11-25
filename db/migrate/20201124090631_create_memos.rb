class CreateMemos < ActiveRecord::Migration[5.2]
  def change
    create_table :memos do |t|
      t.text :title
      t.text :body

      t.timestamps
    end
  end
end
